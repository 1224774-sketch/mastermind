package com.example;

import java.util.Scanner;

public class AgeCheck {

	public static void main(String[] args) {
		// I am 19; let me see if I can drive yet
		Scanner sc = new Scanner(System.in);
		
		System.out.println("how old are you");
		
		int myAge = sc.nextInt();
		
		if (myAge >= 18) {
			System.out.println("I'm old enough to have a driver's license!");
		} else {
			System.out.println("I'm not old enough yet... :*(");
		}
	}
}
