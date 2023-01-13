/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author Luke Sutton
 */
@Generated("jsonschema2pojo")
class TripArr {
    
@SerializedName("trip_id")
@Expose
private int trip_id;
@SerializedName("location")
@Expose
private String location;
@SerializedName("date")
@Expose 
private String date;
@SerializedName("weather")
@Expose
private String weather;
@SerializedName("interested")
@Expose
private String interested;
@SerializedName("user_id_owner")
@Expose
private int user_id_owner;



public int getTrip_id() {
return trip_id;
}
public void setTrip_id(int trip_id){
this.trip_id = trip_id;
}
public String getLocation(){
return location;
}
public void setLocation(String location){
this.location = location;
}
public String getDate() {
return date;
}
public void setDate(String date){
this.date = date;
}  
public String getWeather() {
return weather;
}
public void setWeather(String weather) {
this.weather = weather;
}
public String getInterested(){
    return interested;
}
public void setInterested(String interested){
    this.interested = interested;
}
public int getUser_id_owner(){
    return  user_id_owner;
}
public void setUser_id_owner(int user_id_owner){
    this.user_id_owner = user_id_owner;
}

}































