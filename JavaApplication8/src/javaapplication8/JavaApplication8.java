/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Luke Sutton
 */
public class JavaApplication8 {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    //private static final String GET_URL = "https://csrng.net/csrng/csrng.php?min=1&max=10000";
    private static final String GET_URL = "http://www.7timer.info/bin/api.pl?lon=13&lat=52&product=civillight&output=json";
        
    public static void main(String[] args) throws IOException {
        
        System.out.println("Starting up");
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    //StringBuffer response = new StringBuffer();
                    String response = "";
                    while ((inputLine = in.readLine()) != null) {
                            response = response + inputLine;
                    }
                    in.close();
                    
                    
                    
                    
                    String[] arr = null;
                    arr = response.split(",");
                    String result = arr[3];
                    int start = result.indexOf(":");
                    int end = result.indexOf("}");
                    result = result.substring(start +1,end);
                    System.out.println(result);
                    //JsonObject jsnObj = new Gson().fromJson(response,JsonObject.class);
                    //return response;
            } else {
                    //return "Error";
            }
    }
    
}
    

