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
public class LatLon {

@SerializedName("name")
@Expose
private String name;
@SerializedName("local_names")
@Expose
private LocalNames localNames;
@SerializedName("lat")
@Expose
private double lat;
@SerializedName("lon")
@Expose
private double lon;
@SerializedName("country")
@Expose
private String country;
@SerializedName("state")
@Expose
private String state;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public LocalNames getLocalNames() {
return localNames;
}

public void setLocalNames(LocalNames localNames) {
this.localNames = localNames;
}

public double getLat() {
return lat;
}

public void setLat(double lat) {
this.lat = lat;
}

public double getLon() {
return lon;
}

public void setLon(double lon) {
this.lon = lon;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

}