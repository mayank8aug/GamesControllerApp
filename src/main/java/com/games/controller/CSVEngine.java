package com.games.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.games.model.Game;

@Component
public class CSVEngine {
	
	@Autowired
	private GamesService service;
	
	List<Game> gameList = new ArrayList<Game>();
	
	public List<Game> getGamesList(){
		//System.out.println("No. of games: "+gameList.size());
		return gameList;
	}
	
	public void processCSV(String csvPath) {
		BufferedReader br = null;
		String line = "";
		boolean headerSet = false;
		int i=0;
		String[] game;
		try {
			
			br = new BufferedReader(new FileReader(csvPath));
			while ((line = br.readLine()) != null) {
				if(!headerSet) {
					headerSet = true;
				} else {
					game = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					gameList.add(new Game(i++, game[0], game[1], Double.parseDouble(game[2]), game[3], game[4]));					
				}
			}
		} catch (FileNotFoundException e) {
            System.out.println("Error in fetching file: " + e.getMessage());
        } catch (IOException e) {
        	System.out.println("Error in reading file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in reading game data: " + e.getMessage());
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                	System.out.println("Error in closing file reader: " + e.getMessage());
                }
            }
        }
		
	}

	@PostConstruct
	public void saveAll() {
		String filePath = "src/main/resources/gameData.csv";
		processCSV(filePath);
		try {
			service.saveAllGames(getGamesList());
		} catch (Exception e) {
			//Data already in the Database
			System.out.println("Data already in the Database.");
		}
	}
}
