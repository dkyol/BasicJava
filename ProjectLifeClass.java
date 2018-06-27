
public class ProjectLifeClass {
	
	// Variables 
	public char checkMatrix [][];
	private char writeMatrix [][];
	private int boardsize;
		
	private int r = 0;
	private int c = 0;
	
	private char[][] object = {{' ','*',' '},
 							   {' ',' ','*'},
 							   {'*','*','*'},};
							   
	
	//constructors
	
	public ProjectLifeClass(int s){
		
		this.boardsize = s;
		
		checkMatrix = new char[s][s];
		writeMatrix = new char[s][s];
	}
	
	
	
			
	public int isBoardsize(){
		return boardsize;
		
		}

	
	//setter functions 
	public void setBoardsize(int newBoardsize){
		
		boardsize = (newBoardsize > 4) ? newBoardsize: 5;
	}
	
	

	//Method to print checkMatrix, (needed for application testing)
	
	public void printCheckmatrix(){
		
		//System.out.println("Printing the game board");
		
		for(int i = 0; i < checkMatrix.length; i++){
			
			for(int j = 0; j < checkMatrix[1].length; j++){
				
				
				System.out.print(checkMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	//Method to print Write Matrix
	
	public void printwriteMatrix(){
		
		//System.out.println("Printing the game board");
		
		for(int i = 0; i < writeMatrix.length; i++){
			
			for(int j = 0; j < writeMatrix[1].length; j++){
				
				
				System.out.print(writeMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	//method to put object in checkMatrix
	
	public void putObject(int r, int c)
	{
				
		System.out.println("Putting Object at: "+r+","+c);
		int objectRow = 0;
		int objectCol;
		for(int i= r-1; i < ((r-1)+object.length); i++)
		{
			objectCol = 0;
			for(int j =c-1; j < ((c-1)+object[0].length); j++)
			{
				checkMatrix[i][j] = object[objectRow][objectCol++];
			}
			//advance to next row in object matrix
			objectRow++;
		}
		printCheckmatrix();
	}
	
	public void runIt(){
		
		System.out.println("check matrix first time");
		printCheckmatrix();
		
		System.out.println("write matrix first time");
		printwriteMatrix();
		
		//add contents from check matrix to write matrix 
		/*for(int e = 0; e < checkMatrix.length; e++){
			for(int f = 0; f < checkMatrix[0].length; f++){
				
				writeMatrix[e][f] = checkMatrix[e][f];
		
			}
		}*/
		
		
		//look at check matrix and change necessary parameters on write matrix
		for(int i = 0; i < isBoardsize(); i++){
			for(int j = 0; j < isBoardsize(); j++){
				
				countGrid(i,j);
				
			}
		}
		
		System.out.println("print write matrix after conversion");
		printwriteMatrix();
		
	
	/*for(int a = 0; a < isBoardsize(); a++){
			for(int b = 0; b < isBoardsize(); b++){
				
				System.out.print(writeMatrix[a][b]);
			}
			System.out.println();
		}*/
	
	//update check matrix to write matrix to restart cycle
		/*for(int e = 0; e < checkMatrix.length; e++){
			for(int f = 0; f< checkMatrix[0].length; f++){
				
				checkMatrix[e][f] = writeMatrix[e][f];
		
			}
		}*/
	
		//return checkMatrix;
	}
	
	public void countGrid(int r, int c){
		
		//Calls on corners of board 
	
		if (r==0 && c==0){
			topLeft(0,0);
			}
		if (r==0 && c==isBoardsize()-1){
			topRight(0,isBoardsize()-1);
			}
		if (r==isBoardsize()-1 && c==0){
			bottomLeft(isBoardsize()-1,0);
			}
		if (r==isBoardsize()-1 && c==isBoardsize()-1){
			bottomRight(isBoardsize()-1,isBoardsize()-1);
			}
			
		//Call on sides not including corners 
		
		if ((r==0 && c !=0) || (r==0 && c!= isBoardsize()-2)){
			for(int i = 1; i < isBoardsize()-2; i++){
				topSide(0, i);
			}
		}
		
		if ((r==isBoardsize() && c !=0) || (r==isBoardsize() && c!= isBoardsize()-2)){
			for(int i = 1; i < isBoardsize()-2; i++){
				bottomSide(0, i);
			}
		}
		
		if ((r!=0 && c !=0) || (r== isBoardsize()-2 && c!=0)){
			for(int i = 1; i < isBoardsize()-2; i++){
				leftSide(i, 0);
			}
		}
		
		if ((r!=0 && c ==isBoardsize()-2) || (r== isBoardsize()-2 && c == isBoardsize()-2)){
			for(int i = 1; i < isBoardsize()-2; i++){
				rightSide(i, isBoardsize()-1);
			}
		}
		// call on interior 
		else{
			for( int i = 1; i < isBoardsize()-2; i++){
				for(int j =1; j < isBoardsize()-2; j++){
					
					middleSide(i,j);
				}
			
			}
		}
	
	}
		
	public void topLeft(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c+1]=='*')
			count++;
			if(checkMatrix[r+1][c]=='*')
			count++;
			if(checkMatrix[r+1][c+1]=='*')
			count++;
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void topRight(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c-1]=='*')
			count++;
			if(checkMatrix[r+1][c]=='*')
			count++;
			if(checkMatrix[r+1][c-1]=='*')
			count++;
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}

    public void bottomLeft(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c+1]=='*')
			count++;
			if(checkMatrix[r-1][c]=='*')
			count++;
			if(checkMatrix[r-1][c+1]=='*')
			count++;
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void bottomRight(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c-1]=='*')
			count++;
			if(checkMatrix[r-1][c]=='*')
			count++;
			if(checkMatrix[r-1][c-1]=='*')
			count++;
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void topSide(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c-1]=='*')
			count++;
		if(checkMatrix[r][c+1]=='*')
			count++;
		if(checkMatrix[r+1][c-1]=='*')
			count++;
		if(checkMatrix[r+1][c]=='*')
			count++;
		if(checkMatrix[r+1][c+1]=='*')
			count++;
		
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
		
		count = 0;
	}
	
	public void bottomSide(int r, int c){	
		int count = 0;
		if(checkMatrix[r][c-1]=='*')
			count++;
		if(checkMatrix[r][c+1]=='*')
			count++;
		if(checkMatrix[r+1][c-1]=='*')
			count++;
		if(checkMatrix[r+1][c]=='*')
			count++;
		if(checkMatrix[r+1][c+1]=='*')
			count++;
		
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void leftSide(int r, int c){	
		int count = 0;
		if(checkMatrix[r-1][c+1]=='*')
			count++;
		if(checkMatrix[r][c+1]=='*')
			count++;
		if(checkMatrix[r+1][c+1]=='*')
			count++;
		if(checkMatrix[r+1][c]=='*')
			count++;
		if(checkMatrix[r-1][c]=='*')
			count++;
		
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void rightSide(int r, int c){	
		int count = 0;
				
		if(checkMatrix[r-1][c-1]=='*')
			count++;
		if(checkMatrix[r][c-1]=='*')
			count++;
		if(checkMatrix[r+1][c-1]=='*')
			count++;
		if(checkMatrix[r+1][c]=='*')
			count++;
		if(checkMatrix[r-1][c]=='*')
			count++;
		
		
		if(checkMatrix[r][c]==' '&& count ==3){
			writeMatrix[r][c]='*';
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
	}
	
	public void middleSide(int r, int c){	
		int count = 0;
		
		if(checkMatrix[r+1][c-1]=='*')
			count++;
		if(checkMatrix[r][c-1]=='*')
			count++;
		if(checkMatrix[r-1][c-1]=='*')
			count++;
		if(checkMatrix[r+1][c]=='*')
			count++;
		if(checkMatrix[r-1][c]=='*')
			count++;
		if(checkMatrix[r-1][c+1]=='*')
			count++;
		if(checkMatrix[r][c+1]=='*')
			count++;
		if(checkMatrix[r+1][c+1]=='*')
			count++;
		
		// dead cells 
		if(count == 3){
			writeMatrix[r][c]='*';
			System.out.println("r: "+r+"  c: "+c+"  "+"Count "+count+"|");
			count =0;
		}
		
		if((checkMatrix[r][c]=='*'&& count <=1) ||( checkMatrix[r][c]=='*' && count>3)){
			writeMatrix[r][c]=' ';
		}
		
	}
}