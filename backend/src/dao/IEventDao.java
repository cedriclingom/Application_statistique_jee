package dao;



import javax.ejb.Local;




@Local
public interface IEventDao {
	
	public String getEvents(int id);

}
