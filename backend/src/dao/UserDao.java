package dao;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import entities.User;




@Stateless
public class UserDao implements IUserDao{
	
	@PersistenceContext( unitName = "backend_statistique_db" )
	private EntityManager em;
	
	

	
	
	
	
	
	

	public Response saveUser(User user) {
		
		Response response = Response.ok("{\r\"response\":\"Created\"\r}").build();
		
		if(getUserByEmail(user.getEmail()) == null) {
			
			try {
				
				em.persist(user);				
				
			}catch(Exception e) {
				
				response = Response.ok("{\r\"response\":\"Not Created\"\r}").build();
				
			}
			
		}else {
			
			response = Response.ok("{\r\"response\":\"Already Created\"\r}").build();
		}
		
		return response;		
		
	}
	

	public Response updateUser(User user, String email) {
		
		Response response = null;
		
		User findUser = getUserByEmail(email);
		
		if(findUser != null) {
			
			findUser.setFirstName(user.getFirstName());
			findUser.setLastName(user.getLastName());
			response = Response.ok("{\r\"response\":\"Modified\"\r}").build();
			
		}else {
			
			response = Response.ok("{\r\"response\":\"user not found\"\r}").build();
			
		}
			
			return response;
			
	}
	
	
	public Response loginUser(User user) {
		
		Response response = null;
		
		User findUser = null;
		
		if((user == null) || (user.getEmail() == null && user.getTextPassword() == null)) {
			
			response = Response.ok("{\r\"response\":\"Missing email and password\"\r}").build();
			
		}else if(user.getEmail() == null){
			
			response = Response.ok("{\r\"response\":\"Missing email\"\r}").build();
			
		}else if (user.getTextPassword() == null) {
			
			response = Response.ok("{\r\"response\":\"Missing password\"\r}").build();
			
		}else if(getUserByEmail(user.getEmail()) == null) {
			
			response = Response.ok("{\r\"response\":\"user not found\"\r}").build();
			
		}else {
			
			findUser = getUserByEmail(user.getEmail());			
			if(!findUser.getTextPassword().equals(user.getTextPassword())) {
				
				response = Response.ok("{\r\"response\":\"wrong password\"\r}").build();

			}else {
				findUser.setActive("yes");
				response = Response.ok("{\r\"response\":\"connected\"\r}").build();
				
			}
		}
		
		
		return response;
	}
	
	public Response logOutUser(User user) {
		
		Response response = null;
		
		User findUser = null;
		
		if(user.getEmail() == null){
			
			response = Response.ok("{\r\"response\":\"Missing email\"\r}").build();
			
		}else if (user.getActive() == null) {
			
			response = Response.ok("{\r\"response\":\"Missing connection status\"\r}").build();
			
		}else {
			
			findUser = getUserByEmail(user.getEmail());			
			findUser.setActive(user.getActive());
			response = Response.ok("{\r\"response\":\"Disconnected\"\r}").build();
			
		}
		
		
		return response;
	}
	
	public User getUserInfos(String email) {
		
		return getUserByEmail(email);
	}
	
	
	
	
	
	private User getUserByEmail (String email) {
		
		User user = null;		
		Query request = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
		request.setParameter("email", email);
		try {
			
			user = (User)request.getSingleResult();
			
		}catch(Exception e) {
			
			user = null;
			
		}
		
		return user;
	}
	
	
	public boolean deleteUser(User user) {
		
		return true;
		
	}
	
	
	public boolean getUsers() {
		
		return true;
	}

}
