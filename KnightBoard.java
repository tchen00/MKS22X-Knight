import java.util.*;
public class KnightBoard{
  private int[] rowC = {-2, -1, 1, 2, 2, 1, -1, -2};
  private int[] colC= {1, 2, 2, 1, -1, -2, -2, -1};
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

  //clear method for later use
  private void clear() {
    board = new int[board.length][board[0].length];
  }

  //toString method
  public String toString(){
    String output = "";
    int nRow = board.length;
    int nCol = board[0].length;
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[row].length; col++){
        // adds extra space for double digits
        if (nRow * nCol >= 10 && board[row][col] < 10) output += " ";
        if (board[row][col] == 0){
          output += "_";
        } else{
          output += board[row][col];
        } output += " ";
      } output += "\n";
    } return output;
  }

  public boolean addKnight(int row, int col, int level) {
    //row and col are less than the length of the board but greater than or equal to 0 move on ...
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      // check to see if empty
      if (board[row][col] == 0) {
        // add knight
        board[row][col] = level;
        return true;
      }
    } return false;
  }

  public boolean removeKnight(int row, int col) {
    //row and col are less than the length of the board but greater than or equal to 0 move on ...
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      // check to see if not empty
      if (board[row][col] != 0) {
        // remove knight
        board[row][col] = 0;
        return true;
      }
    }
    return false;
  }
  /**
  Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative or out of bounds.
  @return true when the board is solvable from the specified starting position
  */
  public boolean solve(int startingRow,int startingCol){
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[startingRow].length) {
      // parameter cannot be negative or out of bounds
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          // the board cannot contain non-zero values when start
          throw new IllegalStateException();
        }
      }
    }
    return solveHelper(0,0,1);
  }

  public boolean solveHelper(int startRow, int startCol, int level){
    if (level > board.length * board[0].length) {
      // see if all squares are filled
      return true;
    } else {
      if (addKnight(startRow, startCol, level)) {
        for (int i = 0; i < rowC.length; i++) {
          if (solveHelper(startRow + rowC[i], startCol + colC[i], level + 1)) {
            return true;
          }
      } removeKnight(startRow, startCol);
    }  return false;
    }
  }
  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative or out of bounds.
  @return the number of solutions from the starting position specified
  */
  public int countSolutions(int startingRow, int startingCol){
    if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[startingRow].length) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return countHelper(0,0,1);
  }

  private int countHelper(int row, int col, int level){
    int output = 0;
    if (addKnight(row, col, level)){
      if (level == board.length * board[0].length) {
        removeKnight(row, col);
        return 1;
      } else {
        for (int i = 0; i < rowC.length; i++) {
          output += countHelper(row + rowC[i], col + colC[i], level + 1);
        }
      }
      removeKnight(row, col);
    }
    return output;
  }

  public static void runTest(int i){

    KnightBoard b;
    int[]m =   {4,5,5,5,5};
    int[]n =   {4,5,4,5,5};
    int[]startx = {0,0,0,1,2};
    int[]starty = {0,0,0,1,2};
    int[]answers = {0,304,32,56,64};
    if(i >= 0 ){
      try{
        int correct = answers[i];
        b = new KnightBoard(m[i%m.length],n[i%m.length]);

        int ans  = b.countSolutions(startx[i],starty[i]);

        if(correct==ans){
          System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
        }else{
          System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
        }
      }catch(Exception e){
        System.out.println("FAIL Exception case: "+i);

      }
    }
  }
  public static void main(String[] args) {
    String time;

    System.out.println("SOLVE: (from (0, 0))\n");
    for (int r = 1; r < 100; r++) {
      KnightBoard b = new KnightBoard(r, r);
      long startTime = System.nanoTime();
      try {
        if (r == 51 || r == 52)
          time = "skipped";
        else if (b.solve(0, 0))
          time = Math.round((System.nanoTime()-startTime)/10000.)/100.+"ms";
        else
          time = "unsolvable";
        System.out.printf("\t%dx%d:\t%s%n", r, r, time);
      } catch (StackOverflowError e) {
        System.out.printf("\t%dx%d:\tstack overflow%n", r, r);
        break;
      }
    }
    System.out.println("\nCOUNT SOLUTIONS: (from (0, 0))\n");
    for (int r = 1; r < 6; r++) {
      for (int c = r; c < 6; c++) {
        KnightBoard b = new KnightBoard(r, c);
        long startTime = System.nanoTime();
        try {
          int n = b.countSolutions(0, 0);
          time = Math.round((System.nanoTime()-startTime)/10000.)/100.+"ms";
          System.out.printf("\t%dx%d:\t%d solutions\t\t%s%n", r, c, n, time);
        } catch (StackOverflowError e) {
          System.out.printf("\t%dx%d:\tstack overflow%n", r, c);
          break;
        }
      }
    }
  }
/*
  public static void main(String[] args){
    for(int i = 0; i < 5; i++){
      KnightBoard.runTest(i);
    }
  }
*/
}
