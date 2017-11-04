public class World{
	
	private char [][] country;
	private int row;
	private int column;
	
	public World (){
		
		//country is based on row and column args
		country = new char[row][column];
	}
	
	public World (int row, int column){
		this.row = row;
		this.column = column;
		country = new char[row][column];
		
		}
	
	public void initializeGrid(){
	
		for(int x = 0; x < country.length; x++){
			for (int y = 0; y < country[0].length; y++){
				country[x][y] = ' ';
			}

		}
		//Prints board 
		printGrid();
	}
	
	public void printGrid(){
		for(int x = 0; x < country.length; x++){
			for (int y = 0; y < country[0].length; y++){
				System.out.print(country[x][y]);
			}
			System.out.println();
		}
		
	}
	
	public void diagonals(){
		//forward diagonal
		for(int x = 0; x < country.length; x++){
			for(int y = 0; y <country[0].length; y++){
				if(x==y)
					country[x][y]='*';
			}
		}
		
		//backwards diagnonal 
		for(int a = 0; a < country.length; a++){
			country[(country.length-a-1)][a]='*';
			
		}
		
		//print
		printGrid();
	}
	
	
	public void checkCells(){
		for(int x = 0; x < country.length; x++){
			for(int y = 0; y < country[0].length; y++){
				if (country[x][y] == '*')
				System.out.println("Found live cell at: "+x+" and "+y);
			}
		}
	}
	
		
}