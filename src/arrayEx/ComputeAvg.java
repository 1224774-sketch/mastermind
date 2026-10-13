package arrayEx;

import java.util.Scanner;

public class ComputeAvg {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		double totalscore;
		double sum;
		
		int[] scores = new int[5];
		System.out.println("what grades u got????");
		scores[0] = sc.nextInt();
		scores[1] = sc.nextInt();
		scores[2] = sc.nextInt();
		scores[3] = sc.nextInt();
		scores[4] = sc.nextInt();
		sc.close();
		
		sum = scores[0]+scores[1]+scores[2]+scores[3]+scores[4];
		
		totalscore = (sum/scores.length);
		System.out.println("your avarage is = " + totalscore);
		System.out.println("pritty avarage");
	}

}
