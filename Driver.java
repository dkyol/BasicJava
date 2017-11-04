public class Driver{

	public static void main(String[] args){
		
		int row = 0;
		int column = 0;
		
		if(args.length == 2){
			row = Integer.parseInt(args[0]);
			column = Integer.parseInt(args[1]);
		}
		else{
		System.out.println("Enter only two command line arguments...try again");
		System.exit(1);
		}
		
		// Create instance of World 
		
		World myWorld = new World(row, column);
		
		myWorld.initializeGrid();
		
		myWorld.diagonals();
		
		myWorld.checkCells();
		
	}

}