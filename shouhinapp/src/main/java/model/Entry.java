package model;

import java.io.Serializable;

public class Entry implements Serializable{
	private String name;
	private String price;
	private String dateTime;
	public Entry() {}
	public Entry(String name,String price,String dateTime) {
		this.name=name;
		this.price=price;
		this.dateTime=dateTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
