/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp30231cloud;

/**
 *
 * @author Luke Sutton
 */
import org.json.JSONObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Luke Sutton
 */
@Path("/json")
public class OrchestratorService {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response receiveJson(String jsonString) {
    JSONObject json = new JSONObject(jsonString);

    // Do something with the JSON data here
    System.out.println("Received JSON data: " + json);

    return Response.ok().build();
  }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}