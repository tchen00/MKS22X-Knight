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
    return "";
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
}
