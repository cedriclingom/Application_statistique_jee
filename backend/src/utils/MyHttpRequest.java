package utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	
	private void createConnection(URL url) throws Exception{
		
		initConnection(url);
		connection.setUseCaches(false);
		//connection.setDoInput(true);
	    //connection.setDoOutput(true);
		
	}
	private void sendRequest() throws IOException {
		
		//Send request
	    DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
	    wr.close();
	    wr.close();
	}
	

	private String getResponse() throws IOException {
		
		System.out.println(connection.getRequestMethod());
		InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    String line;
	    StringBuffer response = new StringBuffer(); 
	    while((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    return response.toString();
	}
	
	private void deconnexion() {
		
		if (connection != null) {
			
		      connection.disconnect();
		      
		}
		
	}
	
	
	public String doGet(URL url) {
		
		String response = null;
		
		try {
			
			createConnection(url);
			response = getResponse();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			
			deconnexion();
			
		}
		return response;
		
	}
	
	
	
	
	

}
