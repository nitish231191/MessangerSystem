package org.nitish.Restapi.messanger.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.nitish.Restapi.messanger.model.*;

public class ProfileService {
	
	public List<Profile> getAllProfiles(){
		List<Profile> result = new ArrayList<Profile>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			String sql = "Select * from profiles";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String profileName = rs.getString("Profile_Name");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Profile profile = new Profile(id,profileName,firstName,lastName);
				result.add(profile);
				
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	public Profile getProfile(String profileName){
		Profile profile = null;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			String sql  = "select * from profiles where profile_Name = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, profileName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
			int id = rs.getInt("id");
			String profileNames = rs.getString("profile_Name");
			String firstname = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			profile = new Profile(id,profileNames,firstname,lastname);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profile;
		
	}
    
	public Profile updateProfile(Profile profile){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			String sql = "UPDATE profiles SET profile_Name = ?,first_name = ?,last_name = ? where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, profile.getProfileNames());
			pst.setString(2, profile.getFirstname());
			pst.setString(3, profile.getSecondName());
			pst.setInt(4, profile.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profile;
	}
    
	public Profile addProfile(Profile profile){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			String sql = "INSERT INTO profiles"+"(id,profile_Name,first_name,last_name,created) VALUES"+"(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			int id =0;
			pst.setInt(1, id);
			pst.setString(2, profile.getProfileNames());
			pst.setString(3, profile.getFirstname());
			pst.setString(4, profile.getSecondName());
			Date createdDate = profile.getCreated();
			java.util.Date javadate =profile.getCreated();
			java.sql.Date sqldate = new java.sql.Date(javadate.getTime());
			pst.setDate(5, sqldate);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return profile;	
	}
	
   public void deleteProfile(String profileName){
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
		String sql = "DELETE FROM profiles where profile_Name = ?";
		PreparedStatement pst =conn.prepareStatement(sql);
		pst.setString(1, profileName);
		pst.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}

