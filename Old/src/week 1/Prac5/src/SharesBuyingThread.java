/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
/**
 *
 * @author Luke
 */
public class SharesBuyingThread extends Thread{
    
    public void checkShare(){
        while(true){
            if(Shares.shareprice>20){
                buyShare();
            }
        }
        
    }
    public void buyShare(){
        Shares.shareprice = 0;
    }
    
    
    
    public void run()
    {
        checkShare();
    }
}
