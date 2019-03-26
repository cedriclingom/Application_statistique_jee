package webService;


import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;


import dao.IEventDao;




@ApplicationPath("/")
@Path("/events")

public class EventRestService extends Application{
	
	@EJB
	IEventDao eventDao;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getEvents() {
		
		return eventDao.getEvents();
	}
	
	@GET
	@Path("/typeNames")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEventTypeNameNbparticipations() {
		
		return eventDao.getEventTypeNameNbParticipations();
	}
}
