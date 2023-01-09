/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

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
public class randomId {
    
    public static String getId()throws IOException{
        String response = sendGET();
        return response;
    }
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String GET_URL = "https://csrng.net/csrng/csrng.php?min=1&max=10000";

	private static String sendGET() throws IOException {
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
                        if(response.contains("error")){ //fix this later
                        return ("Max ID's Reached Try Later");
                        }
                        String[] arr = null;
                        arr = response.split(",");
                        String result = arr[3];
                        int start = result.indexOf(":");
                        int end = result.indexOf("}");
                        result = result.substring(start+1,end);
                        return result;
		} else {
			return "Max ID's Reached Try Later";
		}
	}
    

    
}
