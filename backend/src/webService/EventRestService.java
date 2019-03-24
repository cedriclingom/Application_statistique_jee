package webService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;


import dao.IEventDao;
import model.Event;



@ApplicationPath("/calendar")
@Path("/event")
public class EventRestService extends Application{
	
	@EJB
	IEventDao eventDao;
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents(@PathParam("id")int id) {
		
		return eventDao.getEvents(id);
	}

}
