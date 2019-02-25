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
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[row].length; col++){
        if (this.row * this.col >= 10 && board[row][col] < 10) output += " ";
        if (board[row][col] == 0){
          output += "_";
        } else{
          output += board[row][col];
        } output += " ";
      } output += "\n";
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
    KnightBoard a = new KnightBoard(5,5);
    System.out.println(a);
  }
}
