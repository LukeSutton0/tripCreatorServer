/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp30231cloud;


import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class COMP30231Cloud {
  public static void main(String[] args) {
    // Create a JAX-RS client
    Client client = ClientBuilder.newClient();

    // Set the target URL
    WebTarget target = client.target("http://localhost:8080/json");

    // Create a JSON object with some data
    JSONObject json = new JSONObject().put("key", "value");

    // Send a POST request to the /json endpoint with the JSON payload
    Response response = target.request(MediaType.APPLICATION_JSON)
        .post(Entity.json(json.toString()));

    // Print the response status
    System.out.println(response.getStatus());
  }
}


