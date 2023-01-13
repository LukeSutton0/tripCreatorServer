/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Luke Sutton
 */
public class getLatLonFromDest {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    
    public static String get(String destination)throws IOException{
        String response = sendGET(destination);
        return response;
    }
    
	private static String sendGET(String destination) throws IOException {
            String GET_URL = "http://api.openweathermap.org/geo/1.0/direct?q="+destination+"&limit=1&appid=23d037f3a7b5824ebaf6dce1557f48cb";
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
				response = response + inputLine; //json string
			}
			in.close();
                        
                        return response;
		} else {
			return "open weather API Timed out Reached Try Later";
		}
	}
    

}
