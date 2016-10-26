package org.nitish.Restapi.messanger.resources;

import org.nitish.Restapi.messanger.model.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.nitish.Restapi.messanger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	public int id;
	public String message_content;
	public String author;
	public String createdDate;
	
	MessageService msgserv = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(){
		return msgserv.getAllMessages();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg){
		return msgserv.addMessage(msg);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") int id,Message msg){
		   msg.setId(id);
		return msgserv.updateMessage(msg);
		
	}
	
	@DELETE
    @Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") int id,Message msg){
		msg.setId(id);
		msgserv.deleteMessage(msg);
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage( @PathParam("messageId")int id){
		
		MessageService me = new MessageService();	
		return me.getMessage(id);
	}
	
	
	
	

	

}
