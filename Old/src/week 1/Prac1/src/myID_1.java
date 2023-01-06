/**
 * A simple program that prints a greeting message
 * File: myID.java
 */

import java.io.*;
import java.util.Scanner;

public class myID_1
{
   public static void main(String[] args)
   {
       System.out.println("This is the right file");
       int optionChosen = 0;
       String optionChosenString;
       Scanner sUser = new Scanner(System.in);
       while (optionChosen != 5){
            //System.out.print("\033[H\033[2J");
           // System.out.flush();
            System.out.println("Please choose an option: \n (1) Print Name \n (2) Print Email \n (3) Print Module \n (4) Display Menu Options \n (5) Quit Program");
            optionChosenString = sUser.nextLine(); 
            try{
                int inRange = Integer.parseInt(optionChosenString);
                for(int i=1;i<6;i++){
                   if(inRange == i){
                       optionChosen = i;
                   }
                }
            }
          catch(NumberFormatException ex){
                ex.printStackTrace();
               }          
        
       
        //System.out.println(optionChosen);
        switch(optionChosen){
             case 1:
                 String name;
                 System.out.println("Please Enter your name");
                 name = sUser.nextLine();
                 System.out.println("Your name is " + name);

              break;
             case 2:
                 String email;
                 System.out.println("Please Enter your email");
                 email = sUser.nextLine();
                 System.out.println("Your email is " + email);
                 break;
             case 3:
                 try{
                     Scanner sfile = new Scanner(new File("C:/Users/xbox3/OneDrive/Documents/NetBeansProjects/src/Prac1/src/module.txt"));
                     int lineNumber = 1;
                     while(sfile.hasNextLine()){
                         System.out.print(sfile.next()+ " ");
                         lineNumber++;
                     }

                 }
                 catch(FileNotFoundException e){
                     System.out.println("File not found Exception");

                 }
                 String test = sUser.nextLine();
                 //System.out.println("Your module is " + module);
                 break;
             case 4:
                 System.out.println("Printing Menu");
                 break;
             case 5:
                 System.out.println("Exiting");
                 break;
        }
       }
           /*System.out.println("Congratulations '" + name +
                               "', you've just ran your 1st Java program.\n"
                             + "your email is "+ email+"\nyour module is "+module
                             );
             */
           
   }
}
   
   

