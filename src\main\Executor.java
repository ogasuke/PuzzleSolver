package main;


public class PuzzleExecutor {

  /**
   * @param args
   */
  public static void main(String[] args) {

    String problemFileName = args[0];
    String resultFileName = args[1];

    new PuzzleSolver().solvePazzle(problemFileName, resultFileName);
  }

}
