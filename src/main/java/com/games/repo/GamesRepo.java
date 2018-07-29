package com.games.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.games.model.Game;

@Repository
public interface GamesRepo extends CrudRepository<Game, Long>{
	
}
