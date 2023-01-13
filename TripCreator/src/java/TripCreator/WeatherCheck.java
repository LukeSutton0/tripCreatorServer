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
public class WeatherCheck {

@SerializedName("requestWorked")
@Expose
private Boolean requestWorked;
@SerializedName("dateInRange")
@Expose
private Boolean dateInRange;
@SerializedName("weather")
@Expose
private String weather;

public Boolean getRequestWorked() {
return requestWorked;
}

public void setRequestWorked(Boolean requestWorked) {
this.requestWorked = requestWorked;
}

public Boolean getDateInRange() {
return dateInRange;
}

public void setDateInRange(Boolean dateInRange) {
this.dateInRange = dateInRange;
}

public String getWeather() {
return weather;
}

public void setWeather(String weather) {
this.weather = weather;
}
@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append('{');
sb.append('"');
sb.append("requestWorked");
sb.append('"');
sb.append(':');
sb.append(((this.requestWorked == null)?"\"<null>\"":this.requestWorked));
sb.append(',');
sb.append('"');
sb.append("dateInRange");
sb.append('"');
sb.append(':');
sb.append(((this.dateInRange == null)?"\"<null>\"":this.dateInRange));
sb.append(',');
sb.append('"');
sb.append("weather");
sb.append('"');
sb.append(':');
if(this.weather == null){
    sb.append('"');
    sb.append("<null>");
    sb.append('"');
}
else{
    sb.append('"');
    sb.append(this.weather);
    sb.append('"');
}
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), '}');
} else {
sb.append('}');
}
return sb.toString();
}
}