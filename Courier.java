//Locker Puzzle

/* A school has 100 lockers and 100 students. All lockers are closed on the first day of school. 
The first student opens every locker. Then the second student, begins with the second locker and 
closes every other locker. Student begins with the third locker and changes every third locker 
(closes it if it was open, and opens it if it was closed). This program presents the results of 100 
students changing 100 lockers */

public class Courier{
	
	public static void main(String[] args){
		
		//define array
		boolean[] lockerList = new boolean[100];
		
		// first student opens all lockers 
		System.out.println("Student 1");
		System.out.println("---------------------");
		
		for (int x = 0; x < 100; x++){
			lockerList[x] = true;
			if (lockerList[x])
				System.out.println("Locker " + (x + 1) + " is Open");	

		}
		 // Second Student Begins  
		 int count = 1;
		 int z = 2;
		 
		
		for (int y = 2; y < 101; y++){
			for(int i = count; i < 100; i = i + z){
				if (lockerList[i]==true || lockerList[i] ==false)
					lockerList[i]= !lockerList[i];
					System.out.println(i);
		}	
			count++;
			z++;
		
		System.out.println("Student " + y );
		System.out.println("---------------------");
		
		for (int i = 0; i<lockerList.length;i++)
			if (lockerList[i])
				System.out.println("Locker " + (i + 1) + " is Open");
			else
				System.out.println("Locker " + (i + 1) + " is Closed");
			
		
	}
	
}
}