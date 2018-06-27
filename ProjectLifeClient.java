// Project Life Project 

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProjectLifeClient {

	public static void main(String [] args){
		
		int x = 0;
		
		//Request all user defined variables 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter row coordinate to place object:" );
		int locx = input.nextInt();
		System.out.println("Enter column coordinate to place object:" );
		int locy = input.nextInt();
		
		System.out.println("Enter the size of the board: " );
		int boardsize = input.nextInt();
		
		System.out.println("Enter the number of generations:" );
		int genNum = input.nextInt();
		
		System.out.println("Enter the speed of animation in milliseconds:" );
		int sleepTime = input.nextInt();
	
	//constructors

	ProjectLifeClass objectReal = new ProjectLifeClass(boardsize);
	
	objectReal.putObject(locx,locy);
	
	while(x < 1)
		{
			
			try
			{
				for(int y = 1; y <= genNum; y++){
				System.out.println("      Generation: "+y);
				System.out.println("--------------------------");
				objectReal.runIt();
				Thread.sleep(sleepTime);
			}
				
			}
			catch(Exception ex)
			{
				System.out.println("Exception:"+ex.getStackTrace());
			}
			
			x++;
		}
		
	
		

	}
		
}
		
