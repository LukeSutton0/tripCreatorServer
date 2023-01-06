
package hello.world;

import java.util.Scanner;

public class HelloWorld
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		char[] arr = text.toCharArray();
		
		//your code goes here
                
		int arrLeng = arr.length;
		for(int i=arrLeng ;i < 0 ;i--){
			System.out.println(text);
			System.out.println(arr[i]);
		}
		
                system.out.println("Test");
		
	}
}
