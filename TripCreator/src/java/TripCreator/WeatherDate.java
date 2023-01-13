/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Luke Sutton
 */
public class WeatherDate {
    @SerializedName("destination")
    @Expose     
    private String destination;
    
    @SerializedName("date")
    @Expose
    private Integer date;
    
    public String getDestination() {
    return destination;
    }

    public void setDestination(String destination) {
    this.destination = destination;
    }

    public Integer getDate() {
    return date;
    }

    public void setDate(Integer date) {
    this.date = date;
    }
}
