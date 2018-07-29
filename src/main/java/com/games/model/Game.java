package com.games.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="games")
public class Game {
	@Id
	private int id;
	@Column
	private String title;
	@Column
	private String platform;
	@Column
	private double score;
	@Column
	private String genre;
	@Column(name="editorchoice")
	private String editorChoice;
	
	public Game() {
		super();
	}
	public Game(int id, String title, String platform, double score, String genre, String editorChoice) {
		this.id = id;
		this.title = title;
		this.platform = platform;
		this.score = score;
		this.genre = genre;
		this.editorChoice = editorChoice;	
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", platform=" + platform + ", score=" + score + ", genre="
				+ genre + ", editorChoice=" + editorChoice + "]";
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getPlatform() {
		return platform;
	}
	public double getScore() {
		return score;
	}
	public String getGenre() {
		return genre;
	}
	public String getEditorChoice() {
		return editorChoice;
	}
}
