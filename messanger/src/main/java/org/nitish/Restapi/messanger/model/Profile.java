package org.nitish.Restapi.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private int id;
	private String profileNames;
	private String firstname;
	private String secondName;
	private Date created;
	
	public Profile (){
		
	}
	
	public Profile(int id ,String profiles,String firstname,String secondname ){
		this.id = id;
		this.profileNames = profiles;
		this.firstname = firstname;
		this.secondName = secondname;
		this.created = new Date();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getProfileNames() {
		return profileNames;
	}
	public void setProfileNames(String profileNames) {
		this.profileNames = profileNames;
	}
	

}
