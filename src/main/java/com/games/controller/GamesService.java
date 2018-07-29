package com.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.games.model.Game;
import com.games.repo.GamesRepoImpl;

@Component
public class GamesService {
	
	@Autowired
	private GamesRepoImpl repoImpl;

	public void saveAllGames(List<Game> games) {
		repoImpl.save(games);
	}
	
	public List<Object> getCustomGames(String queryStr){
		return repoImpl.runCustomQuery(queryStr);
	}
}
