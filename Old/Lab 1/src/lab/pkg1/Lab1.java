/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Luke Sutton
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String test = "MyTest";
        if (test.equals("MyTest")){
            System.out.println("TestComplete");
        }
        
        int myArray[] = new int[256];
        int lenArray = myArray.length;
        System.out.println(lenArray);
        
        
        List<String> myListOfStrings = new ArrayList<String>();
        Scanner aScannerName = new Scanner(System.in);
        String theInputItself = aScannerName.nextLine();
        
        myListOfStrings.add(theInputItself);
        String retrieved = myListOfStrings.get(0);
        System.out.println(retrieved);
        
    }
    
}
