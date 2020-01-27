/**
* This class is a controller class which is used for request handling for
* crud(add,delete,getsingleitem and getallitems) operations on menu items
*/

package com.sample.webproject.service; //package name

//import the collections from util package
import java.util.HashMap; 
import java.util.Map;
import java.util.Set;

//import the classes for the REST service
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import the other classes in the same project
import com.sample.webproject.model.GenericResponse;
import com.sample.webproject.model.MenuItem;
import com.sample.webproject.service.MenuService;

@Path("/menuitem") //specifying the path name for the url
@Consumes(MediaType.APPLICATION_XML)//takes the xml data
@Produces(MediaType.APPLICATION_XML)//outputs the xml data after marshalling

//implementing the menuservice and overrides its methods to handle requests
public class MenuServiceImpl implements MenuService{ 
	
	private static Map<Integer,MenuItem> items = new HashMap<Integer,MenuItem>();// used to store the list items as a map
    
	/**
	* This method is invoked when xml item is sent using post request
	*   @param menu item 
	*   @return response message
	*/
	@POST          
    @Path("/add") 
	public Response addMenuItem(MenuItem m) { 
	
		GenericResponse response = new GenericResponse(); //instantiate response object to specify the status of operation
		if(items.get(m.getId()) != null){ //check if item already exists
			response.setStatus(false);
			response.setMessage("Item Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		items.put(m.getId(), m); // if item doesnt exist add it to the map.
		response.setStatus(true);
		response.setMessage("Item added successfully");
		return Response.ok(response).build();
	}
	
	/**
	* This method is invoked when we need to get item based upon the id
	*   @param id 
	*   @return menu item as xml data
	*/
	
	@GET
	@Path("/{id}/get")
	public MenuItem getMenuItem(@PathParam("id") int id) {
		return items.get(id); // retrieve the item with given id
	}

	/**
	* This method is invoked when we need to get all the items in the map
	* @param no param
	*  @return array of menu items 
	*/
	@GET
	@Path("/getAll")
	public MenuItem[] getAllMenuItems() {
		Set<Integer> ids = items.keySet();
		MenuItem[] m = new MenuItem[ids.size()]; // creating array of menuitems
		int i=0;
		for(Integer id : ids){
			m[i] = items.get(id);  // storing menuitems by iterating through id
			i++;
		}
		return m;
	}
	
	/**
	* This method is invoked when we need to delete the menu item based upon the id
	*  @return response message
	*/
	
	@DELETE
    @Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse(); //instantiate response object to specify the status of operation
		if(items.get(id) == null){  //check if item doesnt exist
			response.setStatus(false);
			response.setMessage("Item Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build(); //error message is returned
		}
		items.remove(id); //if item exists then remove the item
		response.setStatus(true);
		response.setMessage("Item deleted successfully");
		return Response.ok(response).build(); // returns success response
	}


	
	
}
