package whileLoops;

import java.util.Scanner;

public class SumOfNums {

    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        int sum = 0;
        int round;
        System.out.print("Enter a number (-1 to quit): ");
        int number = console.nextInt();

        for (round=0; round != 9; round++) {
            sum = sum + number;     // moved to top of loop
            System.out.print("Enter a number (-1 to quit): ");
            number = console.nextInt();
        }

        System.out.println("The sum is " + sum);

    }
}