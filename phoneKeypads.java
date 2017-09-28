// David Kyle Miller & Calvin Matthews 
// Week 4 Project 
// Phone Keypads
/* This program takes an letter and outputs the corresponding number from a phone keypad*/

import java.util.Scanner;

public class phoneKeypads {
	

	public static void main (String [] args){
	
	// Accept keyboard input 
	
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a Character ");
	String letters = input.next();
	char letter = letters.toUpperCase().charAt(0);
	
	
	
	// Create Switch Statement
	
	switch (letter){
		
	case 'A': 
	case 'B':
	case 'C': System.out.println("The number 2"); break;
	case 'D': 
	case 'E':
	case 'F': System.out.println("The number 3"); break;
	case 'G': 
	case 'H':
	case 'I': System.out.println("The number 4"); break;
	case 'J': 
	case 'K':
	case 'L': System.out.println("The number 5"); break;
	case 'M': 
	case 'N':
	case 'O': System.out.println("The number 6"); break;
	case 'P': 
	case 'Q':
	case 'R':
	case 'S': System.out.println("The number 7"); break;
	case 'T': 
	case 'U':
	case 'V': System.out.println("The number 8"); break;
	case 'W': 
	case 'X':
	case 'Y':
	case 'Z': System.out.println("The number 9"); break;
	default: System.out.println("Unrecognized Entry");
		

}}} 