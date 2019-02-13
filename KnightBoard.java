public class KnightBoard{
  private int row;
  private int col;
  private int[][] board;
  /*
    @throws IllegalArgumentException when either parameter is <= 0
  */
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException("cannot have negative row and/or column");
    }
    board = new int[startingRows][startingCols];
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


  public boolean solve(int startingRow,int startingCol){
    return true;
  }

  public int countSolutions(int startingRow, int startingCol){
    return 1;
  }

  private boolean solveH(int row, int col, int level){
    return true;
  }

  public static void main(String[] args){
    KnightBoard a = new KnightBoard(10,10);
    System.out.println(a.toString());
  }
}
