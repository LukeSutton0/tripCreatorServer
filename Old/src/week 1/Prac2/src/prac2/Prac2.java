/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2;

/**
 *
 * @author xbox3
 */
public class Prac2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long[] salaries = {24000, 34000, 40000, 21000, 18000};
        
        String[] profession = {"nurse", "teacher", "Architect", "Bus Driver", "Postman"};
        
        int salOver20 = 0;
        long highestSal = 0;
        int highestSalProfessionPos = -1;
        for (int x=0; x<salaries.length;x++){
            if(salaries[x]>20000){
                salOver20++;
            }
            if(highestSal<salaries[x]){
                highestSal = salaries[x];
                highestSalProfessionPos = x;
            }
        }
        
        System.out.println(salOver20 + "salaries over 20k");
        String highestSalText = profession[highestSalProfessionPos];   
        System.out.println("The profession with the highest salary is "+highestSalText);
    }
}
