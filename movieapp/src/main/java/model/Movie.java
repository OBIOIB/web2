package model;

import java.io.Serializable;

public class Movie implements Serializable{
	private String userName;
	private String title;
	private String comment;
	
	public Movie() {}
	public Movie(String userName, String title, String comment) {
		this.userName=userName;
		this.title=title;
		this.comment=comment;
	}
	public String getUserName() {
		return userName;
	}
	public String getTitle() {
		return title;
	}
	public String getComment() {
		return comment;
	}

}
