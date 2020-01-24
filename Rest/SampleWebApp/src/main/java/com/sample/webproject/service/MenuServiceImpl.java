package com.sample.webproject.service;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sample.webproject.model.GenericResponse;
import com.sample.webproject.model.MenuItem;
import com.sample.webproject.service.MenuService;

@Path("/menuitem")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MenuServiceImpl implements MenuService{
	
	private static Map<Integer,MenuItem> items = new HashMap<Integer,MenuItem>();
	
	@POST
    @Path("/add")
	public Response addMenuItem(MenuItem m) {
		GenericResponse response = new GenericResponse();
		if(items.get(m.getId()) != null){
			response.setStatus(false);
			response.setMessage("Item Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		items.put(m.getId(), m);
		response.setStatus(true);
		response.setMessage("Item added successfully");
		return Response.ok(response).build();
	}

	@GET
	@Path("/getmsg")
	public String getmsg()
	{
		return "varun";
	}
	
	
	@GET
	@Path("/{id}/get")
	public MenuItem getMenuItem(@PathParam("id") int id) {
		return items.get(id);
	}

	@GET
	@Path("/getAll")
	public MenuItem[] getAllMenuItems() {
		Set<Integer> ids = items.keySet();
		MenuItem[] m = new MenuItem[ids.size()];
		int i=0;
		for(Integer id : ids){
			m[i] = items.get(id);
			i++;
		}
		return m;
	}
	
	@DELETE
    @Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(items.get(id) == null){
			response.setStatus(false);
			response.setMessage("Item Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		items.remove(id);
		response.setStatus(true);
		response.setMessage("Item deleted successfully");
		return Response.ok(response).build();
	}


	
	
}
