//Week 5 Project 
//Kyle Miller and Calvin Matthews 
//Project Max Occurence 
// project accepts integers until 0 is entered, prints out the max value, and the number of times that number occurs

import java.util.Scanner;

public class maxOccurrence {

	public static void main (String [] args){
	
	Scanner input = new Scanner(System.in);
	
	// declaring variables
	int max = -1;
	int count = 0;
	int number = -1;
	
	// request input until 0 is entered
	while (number != 0){
	System.out.println("Enter a number...");
	number = input.nextInt();
		
		if (number > max){
			max = number;
			count = 0;
		}
		if (number == max){
			count++;
			
	}		

	}
	
System.out.println("The max number is: " + max);
System.out.println("The max number occurs "+ count +" times");
}}