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
public class Dataseries {

@SerializedName("date")
@Expose
private int date;
@SerializedName("weather")
@Expose
private String weather;
@SerializedName("temp2m")
@Expose
private Temp2m temp2m;
@SerializedName("wind10m_max")
@Expose
private int wind10mMax;

/**
* No args constructor for use in serialization
*
*/
public Dataseries() {
}

/**
*
* @param date
* @param wind10mMax
* @param weather
* @param temp2m
*/
public Dataseries(int date, String weather, Temp2m temp2m, int wind10mMax) {
super();
this.date = date;
this.weather = weather;
this.temp2m = temp2m;
this.wind10mMax = wind10mMax;
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

public Temp2m getTemp2m() {
return temp2m;
}

public void setTemp2m(Temp2m temp2m) {
this.temp2m = temp2m;
}

public int getWind10mMax() {
return wind10mMax;
}

public void setWind10mMax(int wind10mMax) {
this.wind10mMax = wind10mMax;
}

}