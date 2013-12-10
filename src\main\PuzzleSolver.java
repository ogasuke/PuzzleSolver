package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vo.PuzzleCondition;
import vo.PuzzleProblem;
import vo.PuzzleSurface;

/**
 * パズルを解くメイン処理でJUNITで処理しています。<br><br>
 *
 * 正常終了の場合、パズルは解け<br>
 * Errorならパズルは解けていないです。
 * @author ogasawara
 */
public class PuzzleSolver {

  private int latestLeafId = 1;
  private PuzzleProblem problem;
  private FileWriter filewriter;

  public void solvePazzle(String problemFileName, String resultFileName) {
    PuzzlePrepareAction prepareAction = new PuzzlePrepareAction();
    try {
      //      fileInit();
      filewriter = prepareAction.resultFileInit(resultFileName);

      PuzzleResult result = PuzzleResult.CONTINUE;

      problem = prepareAction.prepareProblemPazzle(problemFileName, latestLeafId);

      List<PuzzleSurface> moveAllList = new ArrayList<PuzzleSurface>();
      int count = 1000;
      int id = 1;
      for (int i = 0; i < count; i++) {
        moveAllList = new PuzzleMoveAction().move(id, problem);
        result = check(problem, moveAllList);
        if (result != PuzzleResult.CONTINUE) {
          break;
        }
        if (moveAllList.size() == 0) {
          break;
        }
      }

      fileClose();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 新たに追加されたルートがゴール可能か、既に通ったルートかチェックします。
   * @param problem
   * @param moveAllList
   * @return
   * @throws IOException
   */
  private PuzzleResult check(PuzzleProblem problem, List<PuzzleSurface> moveAllList) throws IOException {
    PuzzleResult result = PuzzleResult.CONTINUE;
    problem.getLeafList().clear();
    if (moveAllList.size() == 0) {
      return PuzzleResult.FAIRURE;
    }
    for (PuzzleSurface surface : moveAllList) {

      //ゴールできるか
      if (isGoal(surface)) {
        result = PuzzleResult.SUCCESS;
        System.out.println("【GOAL！！】");
        System.out.println(surface.getRootList().size() + "回の移動でクリアしました。");
        surface.print();

        //結果を出力します。
        for (int root : surface.getRootList()) {
          problem.getPuzzleSurfaceMap().get(root).print(filewriter);
        }
        surface.print(filewriter);
        filewriter.write("【GOAL！！】\r\n");
        filewriter.write(surface.getRootList().size() + "回の移動でクリアしました。\r\n");
        break;
      }

      //既に既存の場合かどうか
      if (!problem.isAlready(surface)) {
        latestLeafId++;
        surface.setPuzzleId(latestLeafId);
        surface.getRootList().add(latestLeafId);
        problem.getLeafList().add(latestLeafId);
        problem.getPuzzleSurfaceMap().put(latestLeafId, surface);

        int[] val = { latestLeafId, latestLeafId };
        int[] valRoot = { surface.getBeforePuzzleId(), latestLeafId };
        problem.getRootList().add(val);
        problem.getRootList().add(valRoot);
        problem.getRootList().add(valRoot);
        if (latestLeafId % 100 == 0) {
          System.out.println(latestLeafId);
        }
        //        surface.print();
        //        surface.print(filewriter);
      }
    }

    return result;
  }

  private boolean isGoal(PuzzleSurface surface) {

    if (surface.getPuzzle4_2() == PuzzleCondition.D &&
        surface.getPuzzle4_3() == PuzzleCondition.D &&
        surface.getPuzzle5_2() == PuzzleCondition.D &&
        surface.getPuzzle5_3() == PuzzleCondition.D) {
      return true;
    } else {
      return false;
    }
  }

  private void fileClose() throws IOException {
    filewriter.close();
  }

}
