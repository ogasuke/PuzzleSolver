package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vo.PuzzleCondition;
import vo.PuzzleProblem;
import vo.PuzzleResult;
import vo.PuzzleSurface;

/**
 * �p�Y�����������C��������JUNIT�ŏ������Ă��܂��B<br><br>
 *
 * ����I���̏ꍇ�A�p�Y���͉���<br>
 * Error�Ȃ�p�Y���͉����Ă��Ȃ��ł��B
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

      System.out.println("�ŏI���ʁF" + result.getMessage());
      fileClose();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * �V���ɒǉ����ꂽ���[�g���S�[���\���A���ɒʂ������[�g���`�F�b�N���܂��B
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

      //�S�[���ł��邩
      if (isGoal(surface)) {
        result = PuzzleResult.SUCCESS;
        System.out.println("�yGOAL�I�I�z");
        System.out.println(surface.getRootList().size() + "��̈ړ��ŃN���A���܂����B");
        surface.print();

        //���ʂ��o�͂��܂��B
        for (int root : surface.getRootList()) {
          problem.getPuzzleSurfaceMap().get(root).print(filewriter);
        }
        surface.print(filewriter);
        filewriter.write("�yGOAL�I�I�z\r\n");
        filewriter.write(surface.getRootList().size() + "��̈ړ��ŃN���A���܂����B\r\n");
        break;
      }

      //���Ɋ����̏ꍇ���ǂ���
      if (!problem.isAlready(surface)) {
        latestLeafId++;
        surface.setPuzzleId(latestLeafId);
        surface.getRootList().add(latestLeafId);
        problem.getLeafList().add(latestLeafId);
        problem.getPuzzleSurfaceMap().put(latestLeafId, surface);

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
