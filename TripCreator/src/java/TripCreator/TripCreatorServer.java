/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;


import com.google.gson.Gson;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Luke Sutton
 */
@Path("Page")
public class TripCreatorServer {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TripCreatorServer
     */
    public TripCreatorServer() {
    }

    /**
    * @return an instance of java.lang.String
    */
    @GET
    @Path("CreateAccount")
    @Produces(MediaType.APPLICATION_JSON)
    public String produceUserID(){
        String result = "error";
        int count = 0;
        String idResult="aaa";
        
       while(result.equals("error")&& count < 5){
            try{
                 idResult = randomId.getId();
            }
            catch(IOException e){
                    e.printStackTrace();
                    idResult = "Error getting ID";
            }
            count = count + 1;
            result = AzureSql.main("INSERT INTO users (user_id) VALUES("+idResult+");",1);
           }      
        //"'{value1:itsValue}'"
        return idResult;
    }
    
    /**
     * POST method for creating an instance of TripCreatorResourceClass
     * @param content representation for the json sent to server
     * @return an response with content of the created resource
     */
    @POST
    @Path("PostId")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postIdToDb(String content){
        
        String sql = "UPDATE users SET pass="+content+"WHERE user_id =123123123;";
        return content;
        //return Response.ok(content, MediaType.APPLICATION_JSON).build();
    }
    
    
    
    @POST
    @Path("myTrips")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String listTripsData(String id){
        String result = "";
        id = id.substring(7,id.length()-2); //get the id from the json string
        try{
             result = AzureSql.main("SELECT * FROM trips WHERE userIdOwner="+id+";",4);
        }
        catch(Exception e){
                e.printStackTrace();
             result = "{"
                     + "\"1\":\"No Trips\""+","
                     + "\"2\":\"Try Creating\""+","
                     + "\"3\":\"Some In\""+","
                     + "\"4\":\"The Top\""+","
                     + "\"5\":\"Right\""
                     + "}";
        }
        //"'{value1:itsValue}'"
        return result;
    }
    
    /**
     * POST method for creating an instance of TripCreatorResourceClass
     * @param weatherDateString representation for the json sent to server
     * @return an response with content of the created resource
     */
    @POST
    @Path("checkWeather")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String checkWeather(String weatherDateString){
        String jsonToReturn = "";
        String weatherResponse;
        
        try{
            Gson gson = new Gson();
            WeatherDate weatherDate = gson.fromJson(weatherDateString,WeatherDate.class); //make destination date obj
            
            String locationResponse = getLatLonFromDest.get(weatherDate.getDestination()); //get lat and lon from date obj openweathermap
            locationResponse = locationResponse.substring(1, locationResponse.length()-1);
            Gson gson2 = new Gson();
            LatLon latlon = gson2.fromJson(locationResponse,LatLon.class);//get lat and lon
            Double lon = latlon.getLon();
            lon = Math.floor(lon *100)/100;
            Double lat = latlon.getLat();
            lat = Math.floor(lat *100)/100;
            weatherResponse = getWeather.get(lon,lat); //get weather json string from 7timer
            //weatherResponse = "{\"product\":\"civillight\",\"init\":\"2023010812\",\"dataseries\":[{\"date\":20230109,\"weather\":\"lightrain\",\"temp2m\":{\"max\":15,\"min\":14},\"wind10m_max\":2},{\"date\":20230110,\"weather\":\"rain\",\"temp2m\":{\"max\":15,\"min\":15},\"wind10m_max\":2},{\"date\":20230111,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":15},\"wind10m_max\":2},{\"date\":20230112,\"weather\":\"rain\",\"temp2m\":{\"max\":17,\"min\":16},\"wind10m_max\":2},{\"date\":20230113,\"weather\":\"rain\",\"temp2m\":{\"max\":18,\"min\":17},\"wind10m_max\":2},{\"date\":20230114,\"weather\":\"rain\",\"temp2m\":{\"max\":25,\"min\":18},\"wind10m_max\":2},{\"date\":20230115,\"weather\":\"rain\",\"temp2m\":{\"max\":20,\"min\":9},\"wind10m_max\":3}]}";

            Gson gson3 = new Gson();
            Weather weather = gson3.fromJson(weatherResponse,Weather.class);  

            WeatherCheck weathercheck = new WeatherCheck();
            for(Dataseries dataseries: weather.getDataseries()){
                if(dataseries.getDate()==(weatherDate.getDate())){ //see if date selected is found
                    weathercheck.setWeather(dataseries.getWeather());
                    weathercheck.setRequestWorked(Boolean.TRUE);
                    weathercheck.setDateInRange(Boolean.TRUE);
                    //return dataseries.getWeather(); //found day for weather
                    break;
                }
                else{
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
    
    
    /**
    * POST method for creating an instance of TripCreatorResourceClass
    * @param tripString representation for the json sent to server
    * @return an response with content of the created resource
    */
   @POST
   @Path("postTrip")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public String postTrip(String tripString){
       String result = "";
       String weatherResponse;
        try{
            Gson gson = new Gson();
            TripPost trippost = gson.fromJson(tripString,TripPost.class);
            String sql = "INSERT INTO trips (location,date,weather,interested,userIdOwner)VALUES('"+trippost.getLocation()+"',"+trippost.getDate()+",'"+trippost.getWeather()+"','"+trippost.getInterested()+"',"+trippost.getUserIdOwner()+")";
            AzureSql.main(sql, 5);
           result = "{\"Post\":\"Complete\"}";
        }
        catch(Exception e){
            result = "Exception";
        }
    
       return result;
   }
   

    
     /**
    * POST method for creating an instance of TripCreatorResourceClass
    * @param id representation for the json sent to server
    * @return an response with content of the created resource
    */
   @POST
    @Path("notMyTrips")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findNotMyTripsList(String id){
        String result = "";
        id = id.substring(7,id.length()-2); //get the id from the json string
        try{
             result = AzureSql.main("SELECT * FROM trips WHERE userIdOwner!="+id+";",4);
        }
        catch(Exception e){
                e.printStackTrace();
             result = "{"
                     + "\"1\":\"No Trips\""+","
                     + "\"2\":\"Try Creating\""+","
                     + "\"3\":\"Some In\""+","
                     + "\"4\":\"The Top\""+","
                     + "\"5\":\"Right\""
                     + "}";
        }
        //"'{value1:itsValue}'"
        return result;
    }
    
    
    /**
    * POST method for creating an instance of TripCreatorResourceClass
     * @param interestString
    * @return an response with content of the created resource
    */

    @PUT
    @Path("postInterests")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateInterests(String interestString) {
        String result = "";

        try{
            Gson gson = new Gson();
            PreferenceJson prefJson = gson.fromJson(interestString,PreferenceJson.class);
            int tripId = prefJson.getTripId();
            String sql = "SELECT interested FROM trips WHERE trip_id ="+tripId+"";
            result = AzureSql.main(sql,6);
            
            //result = result + prefJson.getInterested();
            return result;
            
            //get current
            
            //update with new one appended
            
             //result = AzureSql.main("SELECT * FROM trips WHERE userIdOwner!="+id+";",4);
        }
        catch(Exception e){
                e.printStackTrace();
             result = "{"
                     + "\"1\":\"No Trips\""+","
                     + "\"2\":\"Try Creating\""+","
                     + "\"3\":\"Some In\""+","
                     + "\"4\":\"The Top\""+","
                     + "\"5\":\"Right\""
                     + "}";
        }
        //"'{value1:itsValue}'"
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * POST method for creating an instance of TripCreatorResourceClass
     * @param content representation for the json sent to server
     * @return an response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content){
        content = "{\"I\":\"DID\", \"IT\":LETS, \"GOOOOOOO\":\"New York\"}";
        return content;
        //return Response.ok(content, MediaType.APPLICATION_JSON).build();
    }
}
