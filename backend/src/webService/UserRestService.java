package webService;


import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import dao.IUserDao;
import entities.User;



@ApplicationPath("/")
@Path("/user")

public class UserRestService extends Application{
	
	@EJB
	IUserDao userDao;
	
	
	@GET
	@Path("/infos/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInfos(@PathParam("email")String email) {
		
		return userDao.getUserInfos(email);
		
	}
	
	
	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(User user) {
		 
		return userDao.saveUser(user);
		
	}
	
	@PATCH
	@Path("/registration/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(User user, @PathParam("email")String email) {
				
		return userDao.updateUser(user, email);
		
	}
	
	
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logInUser(User user) {
		
		return userDao.loginUser(user);
	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logOutUser(User user) {
		
		return userDao.logOutUser(user);
	}

}
