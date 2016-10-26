package org.nitish.Restapi.messanger.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.nitish.Restapi.messanger.model.*;



public class MessageService {
	
	public MessageService(){
		Message m= new Message();
		
	}
	
	public List<Message> getAllMessages(){
		
		List<Message> resultlist = new ArrayList<Message>();
		//Message m1 = new Message(1,"this is my first message","Nitish Chandra");
	//	Message m2 = new Message(2,"This is the second message","Ankita Mahajan");
		//Message m3 = new Message(3,"This is the third message","Manas Singh");
		//Message m4 = new Message(4,"This is the fourth message","Shruti Sharma");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Messanger","nitish",null);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select * from messages");
			
			//System.out.println(rs.getR);
			
			while(rs.next()){
			int id = rs.getInt("id");
			String message_content = rs.getString("message_content");
			String author = rs.getString("author");
			
			Message addme = new Message(id,message_content,author);
	
			resultlist.add(addme);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      return resultlist;
	}
    public Message  getMessage(int id){
		 
         Message msg = new Message();
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger","nitish",null);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from messages where id ="+id);
			while(rs.next()){
				msg.setAuthor(rs.getString("author"));
				msg.setId(rs.getInt("id"));
				msg.setMessage(rs.getString("message_content"));
				msg.setCreated(rs.getDate("created"));
				
			}
			
			rs.close();
			stmt.close();
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	return msg;	 
 
	 }
    public List<Message> getMessageByYear(int year){
    	
    	return null;
    }
	public Message addMessage(Message msg) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			Statement stmt = con.createStatement();
			
			String sqlst ="INSERT INTO messages"
			+ "(id, author, message_content, created) VALUES"
			+ "(?,?,?,?)";
			PreparedStatement pst = null;
			
			pst = con.prepareStatement(sqlst);
			
			pst.setInt(1, msg.getId());
			pst.setString(2, msg.getAuthor());
			pst.setString(3, msg.getAuthor());
			java.util.Date utildate = msg.getCreated();
			java.sql.Date jsd = new java.sql.Date(utildate.getTime());
			pst.setDate(4, jsd);
			
			pst.executeUpdate();
			
			
		
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public Message updateMessage(Message msg){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger", "nitish",null);
			String messag = msg.getMessage();
			String sqlst ="UPDATE messages "
			+ "SET message_content = ? where id = ?";
			PreparedStatement ps = null;
			ps = conn.prepareStatement(sqlst);
			ps.setString(1, messag);
			ps.setInt(2,msg.getId()) ;
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return msg;
		
	}
	
	public void deleteMessage(Message msg){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Messanger","nitish",null);
			String sqlst = "DELETE FROM messages where id = ?";
			PreparedStatement pst = conn.prepareStatement(sqlst);
			pst.setInt(1, msg.getId());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
				
	}
}
