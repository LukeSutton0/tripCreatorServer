/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Luke Sutton
 */
@Path("Test")
public class TestGet {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestGet
     */
    public TestGet() {
    }

    /**
     * Retrieves representation of an instance of TripCreator.TestGet
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlain() {
        //TODO return proper representation object
        System.out.println("here");
        String content = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        return content;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
       
        
        
        System.out.println("aa");
        String content = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        return content;
    }

    /**
     * PUT method for updating or creating an instance of TestGet
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }

}
