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
		int currentRow;
		int winCondition = 0;

		boolean playing = true;

		// start of the game
		// ===========================================================================================================================================================================================================
		do {

			// secret code is made

			Random random = new Random();
			for (int i = 0; i != secretCodeField.length; i++) {
				secretCodeField[i] = colors[random.nextInt(colors.length)];
			}

			// Hole 1
// =========================================================================================================================================
			for (currentRow = 1; currentRow <= 10; currentRow++) {
				for (String secretCodeField : secretCodeField) {
					System.out.println(secretCodeField);
				}
				winCondition = 0;

				System.out.println("\nRow " + currentRow);
				// hole input
				for (int j = 0; j < codeBreakerHole.length; j++) {
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

				// Holes check
				// =======================================================================================================================================================================================================================
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
				// Feedback
				// =======================================================================================================================================================================================================================
				System.out.println("\n=========================");
				System.out.print("|");
				for (String pin : codeMakerHole) {
					System.out.print(pin + "|");
				}
				System.out.println("\n=========================");
				System.out.print("|");
				for (String guess : codeBreakerHole) {
					System.out.print(guess + "|");
				}
				System.out.println("\n=========================\n");

				// win check
				// =======================================================================================================================================================================================================================

				if (winCondition >= codeMakerHole.length) {
					gamesWon++;
					System.out.println(WONTXT + "W in the chat. YOU WON!" + RESET);
					System.out.println("You guessed the code in " + currentRow + " row(s)");
					break;
				}
				
			}// end for 
			if (winCondition < codeMakerHole.length) {
				System.out.println("You lost. L bozo \nyou Lost your win streak!\nhow are you so bad???");
			}
			
			System.out.println("\nDo you want to play again? Yes|No");
			String awnser = sc.next();
			
			if (awnser.equalsIgnoreCase("Yes")) {
				System.out.println("Current wins: " + gamesWon + "\n");
			} else {
				System.out.println("You won: " + gamesWon + " games!");
				playing = false;
				break;
			}
			
		} while (playing == true);

		sc.close();
	}
}