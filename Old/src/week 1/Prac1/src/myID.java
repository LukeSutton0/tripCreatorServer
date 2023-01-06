/**
 * A simple program that prints a greeting message
 * File: myID.java
 */

import java.io.*;

public class myID
{
   public static void main(String[] args)
   {
       int optionChosen = 0;
       String optionChosenString;
       while (optionChosen != 5){
           InputStreamReader isr = null;
           BufferedReader br = null;
           isr = new InputStreamReader(System.in);
           br = new BufferedReader(isr);
           try{
             System.out.print("\033[H\033[2J");
             System.out.flush();
             System.out.println("Please choose an option: \n (1) Print Name \n (2) Print Email \n (3) Print Module \n (4) Display Menu Options \n (5) Quit Program");
             optionChosenString = br.readLine(); 
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
            }
           catch(IOException e){
               System.out.println("IO exception");
           }
           //System.out.println(optionChosen);
           switch(optionChosen){
                case 1:
                    String name;
                    isr = new InputStreamReader(System.in);
                    br = new BufferedReader(isr);
                    try{
                        System.out.println("Please Enter your name");
                        name = br.readLine();
                        System.out.println("Your name is " + name);
                     }
                    catch(IOException e){
                         System.out.println("IO exception occured");
                     }
                 break;
                case 2:
                    String email;
                    isr = new InputStreamReader(System.in);
                    br = new BufferedReader(isr);
                    try{
                        System.out.println("Please Enter your email");
                        email = br.readLine();
                        System.out.println("Your email is " + email);
                     }
                    catch(IOException e){
                         System.out.println("IO exception occured");
                     }
                    break;
                case 3:
                    String module;
                    isr = new InputStreamReader(System.in);
                    br = new BufferedReader(isr);
                    try{
                        System.out.println("Please Enter your module");
                        module = br.readLine();
                        System.out.println("Your module is " + module);
                     }
                    catch(IOException e){
                         System.out.println("IO exception occured");
                     }             
                    break;
                case 4:
                    System.out.println("Printing Menu");
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
            }
           /*System.out.println("Congratulations '" + name +
                               "', you've just ran your 1st Java program.\n"
                             + "your email is "+ email+"\nyour module is "+module
                             );
             */
            };
   }
   
   
}

