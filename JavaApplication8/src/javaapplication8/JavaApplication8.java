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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Luke Sutton
 */
public class JavaApplication8 {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    //private static final String GET_URL = "https://csrng.net/csrng/csrng.php?min=1&max=10000";
    
        
    public static void main(String[] args) throws IOException, InterruptedException {
        int lon = -2;
        int lat = 80;
        String GET_URL = "http://www.7timer.info/bin/civillight.php?lon="+lon+"&lat="+lat+"&product=civillight&output=json&lang=en";
        //String GET_URL = "https://www.7timer.info/bin/civillight.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
        //String GET_URL = "
        System.out.println(GET_URL);
        System.out.println("Starting up");
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            System.out.println("Connecting...");
//            while(true){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(lat+"."+lon);
                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
                    System.out.println("trying the reader");
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    //StringBuffer response = new StringBuffer();
                    String response = "";
                    while ((inputLine = in.readLine()) != null) {
                            response = response + inputLine;
                    }
                    in.close();
                    System.out.println(response);
                    //JsonObject jsnObj = new Gson().fromJson(response,JsonObject.class);
                    //return response;
            } 
    
//                else {
//                    lat = lat +5;
//                    lon = lon +4;
                    
            }
        }
            
    
    

    

