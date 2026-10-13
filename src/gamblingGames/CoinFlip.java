package gamblingGames;

import java.util.Random;
import java.util.Scanner;

public class CoinFlip {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		String guess = "";
		String answer = "";
		boolean wantToBid = true;
		int budget = 500;
		int winStreak = 0;
		int bid = 0;
		String[] headsOrTails = { "heads", "tails" };

		answer = headsOrTails[random.nextInt(headsOrTails.length)];

		do {

			System.out.print("wanna bid?: ");
			String userAvailable = sc.next();

			if (userAvailable.equalsIgnoreCase("yes")) {
				wantToBid = true;
				System.out.println("\nyour budget is:" + budget);
				System.out.print("bid amount: ");
				bid = sc.nextInt();
				budget = budget - bid;
				
			} else if (userAvailable.equalsIgnoreCase("no")) {
				wantToBid = false;
				System.out.println("Leave then oR oR oR");
				break;
				
			} else {
				wantToBid = false;
				System.out.println("wtf did you type?");
				break;
			}

			answer = headsOrTails[random.nextInt(headsOrTails.length)];

			if (wantToBid == true){
				System.out.print("heads or tails: ");
				guess = sc.next();
			}

			if (guess.equalsIgnoreCase(answer)) {
				winStreak++;
				System.out.println("\nyou guessed correctly");
				System.out.println("winstreak: " + winStreak);
				budget = budget + (bid * 2);
			} else{
				winStreak = 0;
				System.out.println("\nyou guessed wrong womp womp");
			}

		} while (wantToBid == true && budget>0);
		
		if(budget <= 0) {
			System.out.println("you are bankrupt");
			
			if(bid>budget) {
				System.out.println("You don't have that much money");
				System.out.println("you tried to cheat so now");

			}
		}
		sc.close();
	}

}
