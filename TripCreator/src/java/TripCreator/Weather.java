
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TripCreator;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Weather {

@SerializedName("product")
@Expose
private String product;
@SerializedName("init")
@Expose
private String init;
@SerializedName("dataseries")
@Expose
private List<Dataseries> dataseries = null;

/**
* No args constructor for use in serialization
*
*/
public Weather() {
}

/**
*
* @param init
* @param product
* @param dataseries
*/
public Weather(String product, String init, List<Dataseries> dataseries) {
super();
this.product = product;
this.init = init;
this.dataseries = dataseries;
}

public String getProduct() {
return product;
}

public void setProduct(String product) {
this.product = product;
}

public String getInit() {
return init;
}

public void setInit(String init) {
this.init = init;
}

public List<Dataseries> getDataseries() {
return dataseries;
}

public void setDataseries(List<Dataseries> dataseries) {
this.dataseries = dataseries;
}

}