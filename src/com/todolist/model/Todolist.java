package com.todolist.model;

public class Todolist {
	private int index;
	private String username;
	private String title;
	private String date;
	private String content;
	
	public Todolist() {

	}
	
	

	public Todolist(int index, String username, String title, String date, String content) {
		super();
		this.index = index;
		this.username = username;
		this.title = title;
		this.date = date;
		this.content = content;
	}



	public Todolist(String username, String title, String date, String content) {
		super();
		this.username = username;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
