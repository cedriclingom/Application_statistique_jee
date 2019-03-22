package dao;

import java.util.List;

import javax.ejb.Local;


import model.Event;

@Local
public interface IEventDao {
	
	public List<Event> getEvents(String email);

}
