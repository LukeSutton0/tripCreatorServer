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
public class Temp2m {

@SerializedName("max")
@Expose
private int max;
@SerializedName("min")
@Expose
private int min;

/**
* No args constructor for use in serialization
*
*/
public Temp2m() {
}

/**
*
* @param min
* @param max
*/
public Temp2m(int max, int min) {
super();
this.max = max;
this.min = min;
}

public int getMax() {
return max;
}

public void setMax(int max) {
this.max = max;
}

public int getMin() {
return min;
}

public void setMin(int min) {
this.min = min;
}

}