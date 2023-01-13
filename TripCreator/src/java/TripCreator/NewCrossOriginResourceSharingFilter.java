/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Luke Sutton
 */
@Provider
@PreMatching
public class NewCrossOriginResourceSharingFilter implements ContainerRequestFilter,ContainerResponseFilter {

    /*
    @Override
    public void filter(ContainerRequestContext request) throws IOException {

        // If it's a preflight request, we abort the request with
        // a 200 status, and the CORS headers are added in the
        // response filter method below.
        if (isPreflightRequest(request)) {
            request.abortWith(Response.ok().build());
            return;
        }
    }
     private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
    }

   
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response)
            throws IOException {

        // if there is no Origin header, then it is not a
        // cross origin request. We don't do anything.
        if (request.getHeaderString("Origin") == null) {
            return;
        }

        // If it is a preflight request, then we add all
        // the CORS headers here.
       if (isPreflightRequest(request)) {
            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
            response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.getHeaders().add("Access-Control-Allow-Headers",
                "X-Requested-With, Authorization, " +
                "Accept-Version, Content-MD5, CSRF-Token, Content-Type");
        }
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        
        
        /*
        String origin = request.getHeaders().getFirst("origin");
        origin = ((origin == null) || origin.equals("null")) ? "*" : origin;
        response.getHeaders().add("Access-Control-Allow-Origin", origin);
        response.getHeaders().add("Access-Control-Allow-Methods", "OPTIONS,GET,POST,PUT,DELETE,HEAD");
        response.getHeaders().add("Access-Control-Allow-Headers", "Accept,Content-Type,Authorization,Origin");
        response.getHeaders().add("Access-Control-Expose-Headers", "*");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Vary", "*");
        response.getHeaders().add("Accept-Encoding","gzip,deflate");
        response.getHeaders().add("Accept-language","en-US,en;q=0.9");
        response.getHeaders().add("Max-Age","86000");
        */
                
    }*/
}
