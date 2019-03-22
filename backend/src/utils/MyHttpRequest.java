package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpRequest {

	private HttpURLConnection connection;
	
	
	
	
	
	

	public HttpURLConnection getConnection() {
		
		return connection;
	}

	public void setConnection(HttpURLConnection connection) {
		this.connection = connection;
	}
	
	
	
	private HttpURLConnection initConnection(URL url) throws IOException {
		
		if(connection == null) {
			
			connection = (HttpURLConnection) url.openConnection();
			
		}
		return connection;
	}
	
	public void createConnection(URL url) throws Exception{
		
		initConnection(url);
		connection.setUseCaches(false);
	    connection.setDoOutput(true);
		
	}
	
	
	public void doGet(URL url) {
		
		try {
			
			createConnection(url);
			connection.setRequestMethod("GET");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
	

}
