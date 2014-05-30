package swa.ass4.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

import swa.ass4.client.gui.Users;


@Path("/users")
public class UserManagementModule {

	public UserManagementModule() {
		
		 map = new HashMap<String, UserImpl>();

		UserImpl first = new UserImpl();
		first.setUsername("anna");
		first.setName("Anna");
		first.setPassword("first");
		first.setEmail("anna@unet.univie.ac.at");
		first.setRole(1);

		UserImpl second = new UserImpl();
		second.setUsername("bernhard");
		second.setName("Bernhard");
		second.setPassword("second");
		second.setEmail("bernhard@unet.univie.ac.at");
		second.setRole(2);

		UserImpl third = new UserImpl();
		third.setUsername("carl");
		third.setName("Carl");
		third.setPassword("third");
		third.setEmail("carl@unet.univie.ac.at");
		third.setRole(3);

		UserImpl forth = new UserImpl();
		forth.setUsername("david");
		forth.setName("David");
		forth.setPassword("forth");
		forth.setEmail("david@unet.univie.ac.at");
		forth.setRole(2);

		UserImpl fifth = new UserImpl();
		fifth.setUsername("eva");
		fifth.setName("Eva");
		fifth.setPassword("fifth");
		fifth.setEmail("eva@unet.univie.ac.at");
		fifth.setRole(1);

		map.put(first.getUsername(), first);
		map.put(second.getUsername(), second);
		map.put(third.getUsername(), third);
		map.put(forth.getUsername(), forth);
		map.put(fifth.getUsername(), fifth);
		
		List<UserImpl> usern = new ArrayList<>();
		
	    usern.add(first);
	    usern.add(second);
	    usern.add(third);
	    usern.add(forth);
	    usern.add(fifth);
	    
	    list = new Users();
	    
	    list.setUsers(usern);

	}

	public HashMap<String, UserImpl> map;
	public Users list;

	@Context
	UriInfo url;

	@Context
	Request request;

	String name;

	// @GET
	// @Path("user")
	// @Produces(MediaType.TEXT_PLAIN)
	// public String getUser() throws Exception
	// {
	// UserImpl user = new UserImpl();
	// user.setId(10);
	// user.setFirstName("Pi");
	// user.setLastName("Ka");
	// return user.getLastName();
	// }

	@GET
	@Path("user/{username}")
	@Produces("application/xml")
	public Response getUserById(@PathParam("username") String username) {
		UserImpl user = new UserImpl();
		// user.setId(id);
		// user.setFirstName("Lokesh");
		// user.setLastName("Gupta");
		user = map.get(username);
		return Response.status(200).entity(user).build();
	}
	
	@GET
	@Path("user/all")
	@Produces("application/xml")
	public Users getAllUsers() {
//		ResponseList user = new ResponseList();
//		user.setList(list);
		
		return list;
	}
	
}

//@XmlRootElement(name = "responseList")
//class ResponseList {
//
//    private Users user;
//
//    public Users getList() {
//        return user;
//    }
//
//    public void setList(Users user) {
//        this.user = user;
//    }

//}