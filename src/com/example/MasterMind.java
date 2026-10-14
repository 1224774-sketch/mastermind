package com.example;

import java.util.Random;

import java.util.Scanner;

public class Mastermind {

	static String[] colors = { "Green", "Yellow", "Red", "Purple", "Orange", "Blue" };
	static String[] codeMakerHole = { "", "", "", "" };
	static String[] codeBreakerHole = { "", "", "", "" };
	static String[] secretCodeField = { "", "", "", "" };

	public static void main(String[] args) {
		// ===========================================================================================================================================================================================================
		// Scanner
		Scanner sc = new Scanner(System.in);

		// colors

		final String RESET = "\u001B[0m";
		final String RED = "\u001B[31m";
		final String WHITE = "\u001B[37m";
		final String BLACK = "\u001B[30m";
		final String FEEDBACKB = "\u001b[37;40;1m";
		final String FEEDBACKW = "\u001b[47;1m";
		final String WONTXT = "\u001b[43;1m";

		// ===========================================================================================================================================================================================================

		// CodeMaker-pins
		String black = FEEDBACKB + WHITE + "Black" + RESET;
		String white = FEEDBACKW + BLACK + "White" + RESET;
		String empty = "Empty";

		int gamesWon = 0;

		boolean playing = true;

		// ===========================================================================================================================================================================================================
		do {
			
			int currentRow = 0;
			int winCondition = 0;

			// secret code is made
			Random random = new Random();
			secretCodeField[0] = colors[random.nextInt(colors.length)];
			secretCodeField[1] = colors[random.nextInt(colors.length)];
			secretCodeField[2] = colors[random.nextInt(colors.length)];
			secretCodeField[3] = colors[random.nextInt(colors.length)];

			// Hole 1
// =========================================================================================================================================
			for (currentRow = 1; currentRow <= 10; currentRow++) {
//			should look like (secretCodeField.length)
				for (String secretCodeField : secretCodeField) {
					System.out.println(secretCodeField);
				}
				winCondition = 0;

				System.out.println("\nRow " + currentRow);
				// hole 1 input
				int j = 0;
				for (j = 0; j < codeBreakerHole.length; j++) {
					System.out.print("Choose a color that you want to place in hole " + (j + 1) + ": ");
					boolean correct = false;
					do {
						codeBreakerHole[j] = sc.next();
						for (int i = 0; i < colors.length; i++) {
							if (codeBreakerHole[j].equalsIgnoreCase(colors[i])) {
								correct = true;
							}
						}
						if (correct == false) {
							System.out.print(RED + "Invalid! \n" + RESET
									+ "Choose a color that you want to place in hole " + (j + 1) + ": ");
						}
					} while (correct == false);
				}

				// win check

				// =======================================================================================================================================================================================================================

				// Holes check
				for (int i = 0; i < codeBreakerHole.length; i++) {
					codeMakerHole[i] = empty;
					for (int x = 0; x < codeBreakerHole.length; x++) {
						if (codeBreakerHole[i].equalsIgnoreCase(secretCodeField[x])) {
							codeMakerHole[i] = white;
							if (codeBreakerHole[i].equalsIgnoreCase(secretCodeField[i])) {
								codeMakerHole[i] = black;
							}
						}
					}
					if (codeMakerHole[i].equalsIgnoreCase(black)) {
						winCondition++;
					}
				}

				// =======================================================================================================================================================================================================================

				// Feedback
				
				System.out.println("\n=========================");
				System.out.println("|" + codeMakerHole[0] + "|" + codeMakerHole[1] + "|" + codeMakerHole[2] + "|"
						+ codeMakerHole[3] + "|");
				System.out.println("=========================");
				System.out.println("|" + codeBreakerHole[0] + "|" + codeBreakerHole[1] + "|" + codeBreakerHole[2] + "|"
						+ codeBreakerHole[3] + "|");
				System.out.println("=========================\n");
				if (winCondition >= codeMakerHole.length) {
					gamesWon = gamesWon += 1;
					System.out.println(WONTXT + "W in the chat. YOU WON!" + RESET);
					System.out.println("You guessed the code in " + currentRow + " row(s)");
					System.out.println("\nDo you want to play again? Yes|No");
					String awnser = sc.next();
					if (awnser.equalsIgnoreCase("Yes")) {
						System.out.println("Current wins: " + gamesWon + "\n");
						break;
						
					} else {
						
						if (gamesWon > 1) {
							System.out.println("You won: " + gamesWon + " games!");
							break;
						} else {
							System.out.println("You won: " + gamesWon + " game?" + "\nYou kinda SUCK");
							break;
						}
					}
				} else if (currentRow == 10 && winCondition != codeMakerHole.length) {
					System.out.println("You lost. L bozo \nyou Lost your win streak!\nhow are you so bad???");
					break;
				}
			}
		} while (playing == true);

		sc.close();
	}
}