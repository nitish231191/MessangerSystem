package org.nitish.Restapi.messanger.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Message {
	
	private int id;
	private String message;
	private String author;
	private Date created;
	
	public Message(){
		
	}
	
	public Message(int id,String message,String author){
		this.id =id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
