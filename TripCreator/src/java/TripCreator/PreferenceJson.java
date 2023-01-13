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
public class PreferenceJson {

@SerializedName("trip_id")
@Expose
private int tripId;
@SerializedName("interested")
@Expose
private String interested;

public int getTripId() {
return tripId;
}

public void setTripId(int tripId) {
this.tripId = tripId;
}

public String getInterested() {
return interested;
}

public void setInterested(String interested) {
this.interested = interested;
}

}