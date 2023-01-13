/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

//import javaapplication8.TripArr;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

/**
 *
 * @author Luke Sutton
 */
public class Testing {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Double lon = 100.0;
        Double lat = 80.0;
        //String response = sendGET(lon,lat);
        String a = "{\"destination\": \"London\", \"date\": 20230112}";
        //checkWeather(a);
        //System.out.println(response);
        String result = "";
//        Gson gson = new Gson();
//            String interestString = "{trip_id: \"25,26\", interested: 30}";
//            System.out.println(interestString);
//            PreferenceJson prefJson = gson.fromJson(interestString,PreferenceJson.class);
//            System.out.println("made it");
//            int tripId = prefJson.getTripId();
//            String sql = "SELECT interested FROM trips WHERE trip_id ="+tripId+"";
//            result = AzureSql.main(sql,6);
//            TripArr[] tripArr = gson.fromJson(result,TripArr[].class);
//            String test = "";
//            for(TripArr trip :tripArr){
//                test = test + trip.getTrip_id();
//                trip.getTrip_id();
//            }
        
        
        
        
        
//        String tripString = "{location: 'London', date: '20230113', weather: 'Rain', interested: '4819', userIdOwner: '4819'}";
//        Gson gson = new Gson();
//        System.out.println(tripString);
//        TripPost trippost = gson.fromJson(tripString,TripPost.class);
//        System.out.println(trippost);
//        String sql = "INSERT INTO trips (location,date,weather,interested,userIdOwner)VALUES('"+trippost.getLocation()+"',"+trippost.getDate()+",'"+trippost.getWeather()+"','"+trippost.getInterested()+"',"+trippost.getUserIdOwner()+")";
//        
//        System.out.println(sql);
//        String b = AzureSql.main(sql, 5);
//        System.out.println(b);
        
    }
        
        
    private static String sendGET(Double lon,Double lat) throws IOException {
            String GET_URL = "http://www.7timer.info/bin/api.pl?lon="+lon+"&lat="+lat+"&product=civillight&output=json";
            //String GET_URL = "http://api.openweathermap.org/geo/1.0/direct?q=London&limit=1&appid=23d037f3a7b5824ebaf6dce1557f48cb";
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Here");
            System.out.println(con.getResponseCode());
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
                    System.out.println("Here2");
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    //StringBuffer response = new StringBuffer();
                    String response = "";
                    while ((inputLine = in.readLine()) != null) {
                            response = response + inputLine; //json string
                    }
                    in.close();
                    System.out.println(response);
                    System.out.println(response);
     
            }
            return "";
    }
    
     public static String checkWeather(String weatherDateString){
        String jsonToReturn = "";
        String weatherResponse;
        System.out.println("Test1");
        try{
            Gson gson = new Gson();
            WeatherDate weatherDate = gson.fromJson(weatherDateString,WeatherDate.class); //make destination date obj
            System.out.println("Test2");
            String locationResponse = getLatLonFromDest.get(weatherDate.getDestination()); //get lat and lon from date obj openweathermap
            locationResponse = locationResponse.substring(1, locationResponse.length()-1);
            Gson gson2 = new Gson();
            System.out.println("Test3");
            LatLon latlon = gson2.fromJson(locationResponse,LatLon.class);//get lat and lon
            Double lon = latlon.getLon();
            lon = Math.floor(lon *100)/100;
            Double lat = latlon.getLat();
            lat = Math.floor(lat *100)/100;
            System.out.println("Test4");
            weatherResponse = get2(lon,lat); //get weather json string from 7timer
            //weatherResponse = "{\"product\":\"civillight\",\"init\":\"2023010812\",\"dataseries\":[{\"date\":20230109,\"weather\":\"lightrain\",\"temp2m\":{\"max\":15,\"min\":14},\"wind10m_max\":2},{\"date\":20230110,\"weather\":\"rain\",\"temp2m\":{\"max\":15,\"min\":15},\"wind10m_max\":2},{\"date\":20230111,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":15},\"wind10m_max\":2},{\"date\":20230112,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":16},\"wind10m_max\":2},{\"date\":20230113,\"weather\":\"rain\",\"temp2m\":{\"max\":18,\"min\":17},\"wind10m_max\":2},{\"date\":20230114,\"weather\":\"rain\",\"temp2m\":{\"max\":25,\"min\":18},\"wind10m_max\":2},{\"date\":20230115,\"weather\":\"rain\",\"temp2m\":{\"max\":20,\"min\":9},\"wind10m_max\":3}]}";
            System.out.println(weatherResponse);
            System.out.println("Test5");
            Gson gson3 = new Gson();
            Weather weather = gson3.fromJson(weatherResponse,Weather.class);  
            System.out.println("Test6");
            WeatherCheck weathercheck = new WeatherCheck();
            for(Dataseries dataseries: weather.getDataseries()){
                if(dataseries.getDate()==(weatherDate.getDate())){ //see if date selected is found
                    System.out.println("Test7");
                    weathercheck.setWeather(dataseries.getWeather());
                    weathercheck.setRequestWorked(Boolean.TRUE);
                    weathercheck.setDateInRange(Boolean.TRUE);
                    //return dataseries.getWeather(); //found day for weather
                    break;
                }
                else{
                    System.out.println("Test8");
                    weathercheck.setDateInRange(Boolean.FALSE);
                }
            }
            weathercheck.setRequestWorked(Boolean.TRUE);
            jsonToReturn = weathercheck.toString();
            return jsonToReturn; //didnt find day
            }
        catch(Exception e){
            WeatherCheck weathercheck = new WeatherCheck();
            weathercheck.setRequestWorked(Boolean.FALSE);
            jsonToReturn = weathercheck.toString();
            return jsonToReturn;
        }
    }

                    
    public static String get2(Double lon,Double lat)throws IOException{
        System.out.println("Test4.1");
        String response = sendGET2(lon,lat);
        return response;
    }
	private static String sendGET2(Double lon,Double lat) throws IOException {
            System.out.println("Test4.2");
            String GET_URL = "http://www.7timer.info/bin/api.pl?lon="+lon+"&lat="+lat+"&product=civillight&output=json";
            System.out.println("Test4.3");
		URL obj = new URL(GET_URL);
                System.out.println("Test4.4");
                System.out.println(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                System.out.println("Test4.5");
		con.setRequestMethod("GET");
                System.out.println("Test4.6");
                int count = 0;
                while(count < 10){
                    try{
                        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
                            System.out.println("Test4.7");
                            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String inputLine;
                            String response = "";
                            while ((inputLine = in.readLine()) != null) {
                                    response = response + inputLine; //json string
                            }
                            in.close();
                            return response;
                        }
                    }
                        catch(Exception e){
                            System.out.println("Test4.error");
                            
                            System.out.println("error");   
                    }    
                    count = count +1;
		}
                return "";
        }
                
			
}      
                    
                    
                    
                    
                    
                    
                    
                    
                    
//                    Gson gson3 = new Gson();
//                    Weather weather = gson3.fromJson(response,Weather.class);
//                    System.out.println(weather.getDataseries());

//                    String locationResponse = "[{\"name\":\"Evesham\",\"lat\":52.0940158,\"lon\":-1.9483083,\"country\":\"GB\",\"state\":\"England\"}]";
//                    System.out.println(locationResponse);
//                    locationResponse = locationResponse.substring(1, locationResponse.length()-1);
//                    System.out.println(locationResponse);
//                    Gson gson2 = new Gson();
//                    LatLon latlon = gson2.fromJson(locationResponse,LatLon.class);
//                    System.out.println(latlon.getLat());
//                    System.out.println(latlon.getLon());


//                    String weatherResponse = "{\"product\":\"civillight\",\"init\":\"2023010812\",\"dataseries\":[{\"date\":20230109,\"weather\":\"lightrain\",\"temp2m\":{\"max\":15,\"min\":14},\"wind10m_max\":2},{\"date\":20230110,\"weather\":\"rain\",\"temp2m\":{\"max\":15,\"min\":15},\"wind10m_max\":2},{\"date\":20230111,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":15},\"wind10m_max\":2},{\"date\":20230112,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":16},\"wind10m_max\":2},{\"date\":20230113,\"weather\":\"rain\",\"temp2m\":{\"max\":18,\"min\":17},\"wind10m_max\":2},{\"date\":20230114,\"weather\":\"rain\",\"temp2m\":{\"max\":25,\"min\":18},\"wind10m_max\":2},{\"date\":20230115,\"weather\":\"rain\",\"temp2m\":{\"max\":20,\"min\":9},\"wind10m_max\":3}]}";
//                    Gson gson3 = new Gson();
//                    Weather weather = gson3.fromJson(weatherResponse,Weather.class);  
//                    for(Dataseries dataseries: weather.getDataseries()){
//                        System.out.println(dataseries.getDate());
//                        int date = 20230923;
//                        int date1 = dataseries.getDate();
//
//                    }
//                WeatherCheck weathercheck = new WeatherCheck();
//                weathercheck.setRequestWorked(Boolean.FALSE);
//                System.out.println(weathercheck.toString());
                       
//                    String weatherDateString = "{\"destination\":\"Evesham\", \"date\": 20230111}";
//                    String jsonToReturn = "";
//                    String weatherResponse;
//
//                    try{
//                        Gson gson = new Gson();
//                        WeatherDate weatherDate = gson.fromJson(weatherDateString,WeatherDate.class); //make destination date obj
//                        System.out.println(weatherDate.getDestination());
//                        String locationResponse = getLatLonFromDest.get(weatherDate.getDestination()); //get lat and lon from date obj openweathermap
//                         System.out.println("locat === "+locationResponse);
//                        locationResponse = locationResponse.substring(1, locationResponse.length()-1);
//                        Gson gson2 = new Gson();
//                        System.out.println("here2");
//                        System.out.println(locationResponse);
//                        LatLon latlon = gson2.fromJson(locationResponse,LatLon.class);//get lat and lon
//                        System.out.println("here5");
//                        lon = latlon.getLon();
//                        System.out.println("here5.5");
//                        lat = latlon.getLat();
//                        System.out.println("here6");
//                        weatherResponse = sendGET2(lon,lat); //get weather json string from 7timer
//                        //weatherResponse = "{\"product\":\"civillight\",\"init\":\"2023010812\",\"dataseries\":[{\"date\":20230109,\"weather\":\"lightrain\",\"temp2m\":{\"max\":15,\"min\":14},\"wind10m_max\":2},{\"date\":20230110,\"weather\":\"rain\",\"temp2m\":{\"max\":15,\"min\":15},\"wind10m_max\":2},{\"date\":20230111,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":15},\"wind10m_max\":2},{\"date\":20230112,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":16},\"wind10m_max\":2},{\"date\":20230113,\"weather\":\"rain\",\"temp2m\":{\"max\":18,\"min\":17},\"wind10m_max\":2},{\"date\":20230114,\"weather\":\"rain\",\"temp2m\":{\"max\":25,\"min\":18},\"wind10m_max\":2},{\"date\":20230115,\"weather\":\"rain\",\"temp2m\":{\"max\":20,\"min\":9},\"wind10m_max\":3}]}";
//                        System.out.println(weatherResponse);
//                        System.out.println("here3");
//                        Gson gson3 = new Gson();
//                        Weather weather = gson3.fromJson(weatherResponse,Weather.class);  
//
//                        WeatherCheck weathercheck = new WeatherCheck();
//                        System.out.println("here4");
//                        for(Dataseries dataseries: weather.getDataseries()){
//                            if(dataseries.getDate()==(weatherDate.getDate())){ //see if date selected is found
//                                weathercheck.setWeather(dataseries.getWeather());
//                                weathercheck.setRequestWorked(Boolean.TRUE);
//                                weathercheck.setDateInRange(Boolean.TRUE);
//                                //return dataseries.getWeather(); //found day for weather
//                                break;
//                            }
//                            else{
//                                weathercheck.setDateInRange(Boolean.FALSE);
//                            }
//                        }
//                        jsonToReturn = weathercheck.toString();
//                        return jsonToReturn; //didnt find day
//                    }
//                    catch(Exception e){
//                        WeatherCheck weathercheck = new WeatherCheck();
//                        weathercheck.setRequestWorked(Boolean.FALSE);
//                        jsonToReturn = weathercheck.toString();
//                        return jsonToReturn;
//                    }
//
//                         
//                        } else {
//                                return "Error";
//                        }
    
    
        
        
        
//        String weatherDateString = "{\"destination\":\"mydest\",\"date\":\"2023-01-11\"}";
//        String result = "";
//        Gson gson = new Gson();
//        WeatherDate weatherDate = gson.fromJson(weatherDateString,WeatherDate.class);
//        System.out.println(weatherDate.getDestination());
    
    
//    
//    
    
    

