/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Luke Sutton
 */
public class getWeather {
        
    private static final String USER_AGENT = "Mozilla/5.0";
    
    
    public static String get(Double lon,Double lat)throws IOException{
        String response = sendGET(lon,lat);
        return response;
    }
	private static String sendGET(Double lon,Double lat) throws IOException {
            String GET_URL = "http://www.7timer.info/bin/civillight.php?lon="+lon+"&lat="+lat+"&product=civillight&output=json"; //not machine
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
                        String response = "";
			while ((inputLine = in.readLine()) != null) {
				response = response + inputLine; //json string
			}
			in.close();
                        return response;
		} else {
			return "7 Timer API Maxed out";
		}
	}
}
