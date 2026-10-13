
package whileLoops;

import java.util.Scanner;

public class SquareRootWhile {
public static void main(String args[]) {
	
		int total = 0;
		int number = 0;
		
		Scanner console = new Scanner(System.in);
		
		
		 while (number!=-1){
			total = total + number;
			System.out.println("your total is: "+ total);
			System.out.print("Type a non-negative integer: ");
			number = console.nextInt();
		}
		console.close();
	}

}
