package dao;

import java.net.MalformedURLException;
import java.net.URL;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import utils.MyHttpRequest;

@Stateless
public class EventDao implements IEventDao{
	
	
	@PersistenceContext( unitName = "backend_statistique_db" )
	private EntityManager em;
	

	@Override
	public String getEvents(int id) {
		
		String response = null;
		
		try {
			
				StringBuilder stringBuilder = new StringBuilder("http://localhost:8080/backend_calendrier/eventUser/");
		        stringBuilder.append(id);
		        URL url = new URL(stringBuilder.toString());
		        MyHttpRequest myHttpRequest = new MyHttpRequest();
		        response = myHttpRequest.doGet(url);
		        
		} catch (MalformedURLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Pb de requête!");
		}
		return response;
	}

}
