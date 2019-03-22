package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents(@QueryParam("email")String email) {
		
		return eventDao.getEvents(email);
	}

}
