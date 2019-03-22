package dao;




import javax.ejb.Local;
import javax.ws.rs.core.Response;

import entities.User;

@Local
public interface IUserDao {
	
	public Response saveUser(User user);
	
	public Response updateUser(User user, String email);
	
	public Response loginUser(User user);
	
	public Response logOutUser(User user);
	
	public User getUserInfos(String email);	
	
	public boolean deleteUser(User user);
	
	public boolean getUsers();

}
