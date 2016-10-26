package org.nitish.Restapi.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nitish.Restapi.messanger.model.*;
import org.nitish.Restapi.messanger.service.*;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileSrv = new ProfileService();
	
	
	@GET
	public List<Profile> getAllProfiles(){
		return profileSrv.getAllProfiles();	
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileSrv.addProfile(profile);
		}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName){
		profileSrv.deleteProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile){
		profile.setProfileNames(profileName);
	return 	profileSrv.updateProfile(profile);
			
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName){
		return profileSrv.getProfile(profileName);
	}
}
