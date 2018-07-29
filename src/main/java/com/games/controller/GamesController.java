package com.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.games.model.ResponseObject;

@RestController
@RequestMapping("/")
public class GamesController {

	@Autowired
	private CSVEngine csvEngine;

	@Autowired
	private GamesService service;

	@RequestMapping("/save")
	public void saveAllData() {
		String filePath = "src/main/resources/gameData.csv";
		csvEngine.processCSV(filePath);
		csvEngine.saveAll();
	}

	@RequestMapping("/get")
	@CrossOrigin("*")
	public @ResponseBody ResponseObject getData(@RequestParam String pageNo, @RequestParam String sortType, @RequestParam String sortOrder, @RequestParam String searchQuery) {

		String query = createCustomQuery(pageNo, sortType, sortOrder, searchQuery);
		String countQuery = createCountQuery(searchQuery);
		//System.out.println(query);
		//System.out.println(countQuery);
		
		List<Object> paginatedGames = service.getCustomGames(query);
		List<Object> allGames = service.getCustomGames(countQuery);
		
		ResponseObject response = new ResponseObject(paginatedGames, allGames.size());
		
		//System.out.println(paginatedGames);
		return response;
	}
	
	private String createCountQuery(String searchQuery) {
		return "select * from gamesdb.games where title like '%"+searchQuery+"%'";
	}

	private String createCustomQuery (String pageNo, String sortType, String sortOrder, String searchQuery) {
		return "select * from gamesdb.games where title like '%"+searchQuery+"%' order by "+sortType+" "+sortOrder+" LIMIT "+10*(Integer.parseInt(pageNo)-1) +",10";
	}

}
