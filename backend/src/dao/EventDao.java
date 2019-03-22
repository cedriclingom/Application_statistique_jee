package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import model.Event;

@Stateless
public class EventDao implements IEventDao{
	
	
	@PersistenceContext( unitName = "backend_statistique_db" )
	private EntityManager em;
	

	@Override
	public List<Event> getEvents(String email) {
		// TODO Auto-generated method stub
		return new ArrayList<Event>();
	}

}
