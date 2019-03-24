package utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class CORSRequestFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");

		// TODO Auto-generated method stub
		
	}

}
