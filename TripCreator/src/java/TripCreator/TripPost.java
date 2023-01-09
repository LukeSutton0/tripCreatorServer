/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package TripCreator;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class TripPost {

@SerializedName("location")
@Expose
private String location;
@SerializedName("date")
@Expose
private int date;
@SerializedName("weather")
@Expose
private String weather;
@SerializedName("interested")
@Expose
private String interested;
@SerializedName("userIdOwner")
@Expose
private int userIdOwner;

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public int getDate() {
return date;
}

public void setDate(int date) {
this.date = date;
}

public String getWeather() {
return weather;
}

public void setWeather(String weather) {
this.weather = weather;
}

public String getInterested() {
return interested;
}

public void setInterested(String interested) {
this.interested = interested;
}

public int getUserIdOwner() {
return userIdOwner;
}

public void setUserIdOwner(int userIdOwner) {
this.userIdOwner = userIdOwner;
}

}