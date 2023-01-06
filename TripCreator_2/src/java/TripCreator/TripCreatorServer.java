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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Luke Sutton
 */
@Path("Page1")
public class TripCreatorServer {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TripCreatorServer
     */
    public TripCreatorServer() {
    }

    /**
     * Retrieves representation of an instance of TripCreator.TripCreatorServer
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String result = AzureSql.main("SELECT","users","user_id");
        //TODO return proper representation object
        return result;
    }

    /**
     * PUT method for updating or creating an instance of TripCreatorServer
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    /**
     * POST method for creating an instance of TripCreatorResourceClass
     * @param content representation for the json sent to server
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content){
        content = "{\"I\":\"DID\", \"IT\":LETS, \"GOOOOOOO\":\"New York\"}";
        return content;
        //return Response.ok(content, MediaType.APPLICATION_JSON).build();
    }
   
    
    /*public Response postJson(String content) {
        JsonReader stringRead = Json.createReader(new StringReader(content));
        JsonObject myJsonObject = stringRead.readObject();
        String aValue = myJsonObject.getString("aValue");
        //Response.created(context.getAbsolutePath()).build()
        String someJson = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
       
        Response postResponse = Response.created(context.getAbsolutePath()).type(MediaType.APPLICATION_JSON).entity(someJson).build();
        return postResponse;
    }*/
}
