package com.games.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.games.model.Game;

@Repository
public class GamesRepoImpl implements GamesRepo {
	
	@Autowired
	private EntityManager mgr;
	
	public List<Object> runCustomQuery(String queryStr){
		Query query = mgr.createNativeQuery(queryStr, Game.class);
		List<Object> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public <S extends Game> S save(S entity) {
		mgr.persist(entity);
		return null;
	}

	@Override
	@Transactional
	public <S extends Game> Iterable<S> save(Iterable<S> entities) {
		for(S entity: entities) {
			save(entity);
		}
		return entities;
	}

	@Override
	public Game findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Game> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Game> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Game entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Game> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
