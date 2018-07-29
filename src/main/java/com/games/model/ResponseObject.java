package com.games.model;

import java.util.List;

public class ResponseObject {
	
	private List<Object> data;
	
	private int count;
	
	public ResponseObject(List<Object> data, int count) {
		this.data = data;
		this.count = count;
	}

	public List<Object> getData() {
		return data;
	}

	public int getCount() {
		return count;
	}

}
