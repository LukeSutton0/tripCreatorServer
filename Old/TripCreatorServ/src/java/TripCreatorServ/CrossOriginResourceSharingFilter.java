/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreatorServ;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Luke Sutton
 */
@Provider
public class CrossOriginResourceSharingFilter implements ContainerResponseFilter {

    @Override //overide the header to send back
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS,GET,POST,PUT,DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Accept,Content-Type,Authorization,Origin");
        response.getHeaders().putSingle("Access-Control-Expose-Headers", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Credentials", "false");
    }
}
