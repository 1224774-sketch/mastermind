
package com.example;

import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        String custName = "Mary Smith";
        String itemDesc = "Shirt";
        
        Scanner sc = new Scanner(System.in);
        
	// numeric fields 
        int quantity = 50;
        int price = 20;
        double tax = 1.04;
	double total;
	boolean outOfStock = false;
	String message = custName+" wants to purchase "+quantity+" "+itemDesc;
	// Calculating total cost
        total = (price*quantity)*tax;

        
        // Declare outOfStock variable and initialize it
        System.out.println("how many shirt(s) do you want to purchase");
        int buyerQuantity = sc.nextInt();
        
        
        if(buyerQuantity>quantity) {
        	outOfStock = true;
        } 
        
        // Test outOfStock and notify user in either case.  
         if(outOfStock) {
         	System.out.println("Out of Stock we only have "+quantity+" shirts left");
         }else {
        	 message = ("Your total is:"+total);
        	 System.out.println(message);
         }
         
        sc.close();
        
    }
    
}


