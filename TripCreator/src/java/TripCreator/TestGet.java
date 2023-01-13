/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

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
        String content = "{\"name\":\"John\", \"age\":10, \"city\":\"New York\"}";
        return content;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        String content = "{\"name\":\"John\", \"age\":20, \"city\":\"New York\"}";
        return content;
    }
}
