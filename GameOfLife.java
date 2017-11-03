/* 

Create a game board using a 10 x 10 array of char.   

Place a glider in the array*/

import java.util.Scanner;
public class GameOfLife{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// initializing 10 x 10 glider board 
		char [] [] gameboard = new char [10][10];
			
			// populating glider board with ' ' characters
			for(int x = 0; x < gameboard.length; x++){
				for (int y = 0; y < gameboard[0].length; y++){ 
					gameboard[x][y] = ' ';					
			}
			
			}
			// requesting user input for location of glider
			System.out.println("Enter central x coordiante of glider");
			int xc = input.nextInt();
			
			System.out.println("Enter central x coordiante of glider");
			int yc = input.nextInt();
			
			// glider configuration 
			gameboard[xc][yc] = '*';
			gameboard[xc][yc+1] = '*';
			gameboard[xc+1][yc-1] = '*';
			gameboard[xc-1][yc] = '*';
			gameboard[xc+1][yc+1] = '*';
			
			//printing glider and board
			for(int x = 0; x < gameboard.length; x++){
				for (int y = 0; y < gameboard[0].length; y++){ 
					System.out.print(gameboard[x][y] + "  ");					
			}
					System.out.println();			
			}
			
			

	}
}

  