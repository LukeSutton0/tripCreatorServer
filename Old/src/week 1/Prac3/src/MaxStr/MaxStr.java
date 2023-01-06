/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxStr;

import java.util.ArrayList;

/**
 *
 * @author xbox3
 */
public class MaxStr {
    
    public String findMax (ArrayList<String> a){
        String currentLongestString = "";
        for (int x=0;x<a.size();x++){
            if(a.get(x).length() > currentLongestString.length()){
                currentLongestString = a.get(x);
            }                
        }
        return currentLongestString;
    }
    
}
