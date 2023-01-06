/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripcreator5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;


public class TripCreator5 {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        //synchronousRequest();
        asynchronousRequest();
    }

    private static void asynchronousRequest() throws InterruptedException, ExecutionException {

        // create a client
        HttpClient client = HttpClient.newHttpClient();

        // create a request
        HttpRequest request = HttpRequest.newBuilder(
            URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
            .header("accept", "application/json")
            .build();

        HttpClient responseFuture = client.sendAsync(request, new JsonBodyHandler<>(APOD.class));

        // We can do other things here while the request is in-flight

        // This blocks until the request is complete
        HttpResponse<Void> response = responseFuture.get();

        // the response:
        //System.out.println(response.body().get().title);
    }

    private static void synchronousRequest() throws IOException, InterruptedException {
        // create a client
        HttpClient client = HttpClient.newHttpClient();

        // create a request
        HttpRequest request = HttpRequest.newBuilder(
            URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
        ).build();

        // use the client to send the request
       // HttpResponse<Supplier<APOD>> response = client.send(request, new JsonBodyHandler<>(APOD.class));

        // the response:
        //System.out.println(response.body().get().title);
    }

}