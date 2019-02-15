public class KnightBoard{
  private int row;
  private int col;
  private int[][] board;
  /**
    *@throws IllegalArgumentException when either parameter is <= 0
  */
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException("cannot have negative row and/or column");
    }
    board = new int[startingRows][startingCols];
  }

  /**
    toString: you get a blank board if you never called solve or when there is no solution
              blank boards display 0's as underscores
    *@return the properly formatted string
  */
  public String toDebug(){
    return "";
  }

  public String toString(){
    String output = "";
    for (int r=0;r<board.length;r++){
      for (int c=0;c<board[r].length;c++){
	      if (board.length*board[r].length<10){
		     if (board[r][c]==0){
			     output+="_";
		     }
		     else{
			     output += " " + board[r][c]+ " ";
		     }
	     }
	     else{
		     if (board[r][c]<10){
			    if (board[r][c]==0){
				    output += "_";
			     }
			     else{
				     output += " " + board[r][c] + " ";
			     }
		     }
		     else{
			     output += board[r][c] + " ";
		     }
	     }
     } output+= "\n";
    } return output;
  }

  /**
  Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative or out of bounds.
  @return true when the board is solvable from the specified starting position
  */
  public boolean solve(int startingRow,int startingCol){
    return false;

  }

  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative or out of bounds.
  @return the number of solutions from the starting position specified
  */
  public int countSolutions(int startingRow, int startingCol){
    return 1;
  }

  private boolean solveH(int row, int col, int level){
    return true;
  }

  public static void main(String[] args){
    KnightBoard a = new KnightBoard(30,10);
    System.out.println(a.toString());
  }
}
