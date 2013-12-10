package main;

import java.util.ArrayList;
import java.util.List;

import vo.PuzzleCondition;
import vo.PuzzleProblem;
import vo.PuzzleSurface;

/**
 * パズルの移動を考慮します。
 * @author ogasawara
 */
public class PuzzleMoveAction {

  /**
   * 移動可能なルート全てを列挙します。
   * @param id
   * @param problem
   * @return
   */
  protected List<PuzzleSurface> move(int id, PuzzleProblem problem) {
    List<PuzzleSurface> leafList = new ArrayList<PuzzleSurface>();
    //移動できるパターン全て実施

    for (int leafId : problem.getLeafList()) {
      PuzzleSurface surface = problem.getPuzzleSurfaceMap().get(leafId);
      //空白の場所を特定
      int[] blankPosition = surface.getBlank();

      //位置情報の差が１と１０のとき、となり同士です
      if (blankPosition[1] - blankPosition[0] == 1
          || blankPosition[1] - blankPosition[0] == 10) {
        moveBlankTwo(problem, leafList, surface, blankPosition);
      }
      moveBlankOne(problem, leafList, surface, blankPosition[0]);
      moveBlankOne(problem, leafList, surface, blankPosition[1]);

    }

    return leafList;

  }

  /**
   * 2つの空白があり、そこに小以外のブロックが移動できるときの移動を列挙します。
   * @param leafList
   * @param surface
   * @param blankPositions
   */
  private void moveBlankTwo(PuzzleProblem problem, List<PuzzleSurface> leafList, PuzzleSurface surface, int[] blankPosition) {

    int blankPosition0 = blankPosition[0];
    int blankPosition1 = blankPosition[1];

    //横に2つ並んでいる時
    if (blankPosition1 - blankPosition0 == 1) {

      //大のピースが上に並ぶとき
      if (surface.isPeacePosition(blankPosition0 - 20)
          && surface.isPeacePosition(blankPosition1 - 20)
          && surface.getPeaceCondition(blankPosition1 - 10) == PuzzleCondition.D
          && surface.getPeaceCondition(blankPosition0 - 10) == PuzzleCondition.D) {

        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition0-10, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition1-10, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition0 - 20, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 - 20, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //横のピースが上に並ぶとき
      if (surface.isPeacePosition(blankPosition0 - 10)
          && surface.isPeacePosition(blankPosition1 - 10)
          && surface.getPeaceCondition(blankPosition1 - 10) == PuzzleCondition.Y
          && surface.getPeaceCondition(blankPosition0 - 10) == PuzzleCondition.Y
          && !((surface.isPeacePosition(blankPosition0 - 11) && surface.getPeaceCondition(blankPosition0 - 11) == PuzzleCondition.Y)
          && (surface.isPeacePosition(blankPosition1 - 9) && surface.getPeaceCondition(blankPosition1 - 9) == PuzzleCondition.Y))) {

        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.Y);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.Y);
        newSurface.setPeaceCondition(blankPosition0 - 10, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 - 10, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //大のピースが下に並ぶとき
      if (surface.isPeacePosition(blankPosition0 + 20)
          && surface.isPeacePosition(blankPosition1 + 20)
          && surface.getPeaceCondition(blankPosition1 + 10) == PuzzleCondition.D
          && surface.getPeaceCondition(blankPosition0 + 10) == PuzzleCondition.D) {

        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition0+10, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition1+10, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition0 + 20, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 + 20, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //横のピースが下に並ぶとき
      if (surface.isPeacePosition(blankPosition0 + 10)
          && surface.isPeacePosition(blankPosition1 + 10)
          && surface.getPeaceCondition(blankPosition1 + 10) == PuzzleCondition.Y
          && surface.getPeaceCondition(blankPosition0 + 10) == PuzzleCondition.Y
          && !((surface.isPeacePosition(blankPosition0 + 9) && surface.getPeaceCondition(blankPosition0 + 9) == PuzzleCondition.Y)
          && (surface.isPeacePosition(blankPosition1 + 11) && surface.getPeaceCondition(blankPosition1 + 11) == PuzzleCondition.Y))) {

        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.Y);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.Y);
        newSurface.setPeaceCondition(blankPosition0 + 10, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 + 10, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }

      //縦に2つ並んでいる時
    } else if (blankPosition1 - blankPosition0 == 10) {

      //大のピースが左に並ぶとき
      if (surface.isPeacePosition(blankPosition0 - 2)
          && surface.isPeacePosition(blankPosition1 - 2)
          && surface.getPeaceCondition(blankPosition1 - 1) == PuzzleCondition.D
          && surface.getPeaceCondition(blankPosition0 - 1) == PuzzleCondition.D) {
        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition0-1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition1-1, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition0 - 2, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 - 2, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //縦のピースが左に並ぶとき
      if (surface.isPeacePosition(blankPosition0 - 1)
          && surface.isPeacePosition(blankPosition1 - 1)
          && surface.getPeaceCondition(blankPosition1 - 1) == PuzzleCondition.T
          && surface.getPeaceCondition(blankPosition0 - 1) == PuzzleCondition.T
          && !((surface.isPeacePosition(blankPosition0 - 11) && surface.getPeaceCondition(blankPosition0 - 11) == PuzzleCondition.T)
          && (surface.isPeacePosition(blankPosition1 + 9) && surface.getPeaceCondition(blankPosition1 + 9) == PuzzleCondition.T))) {
        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.T);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.T);
        newSurface.setPeaceCondition(blankPosition0 - 1, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 - 1, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //大のピースが右に並ぶとき
      if (surface.isPeacePosition(blankPosition0 + 2)
          && surface.isPeacePosition(blankPosition1 + 2)
          && surface.getPeaceCondition(blankPosition1 + 1) == PuzzleCondition.D
          && surface.getPeaceCondition(blankPosition0 + 1) == PuzzleCondition.D) {

        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition0+1, PuzzleCondition.D);
        //        newSurface.setPeaceCondition(blankPosition1+1, PuzzleCondition.D);
        newSurface.setPeaceCondition(blankPosition0 + 2, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 + 2, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
      //縦のピースが右に並ぶとき
      if (surface.isPeacePosition(blankPosition0 + 1)
          && surface.isPeacePosition(blankPosition1 + 1)
          && surface.getPeaceCondition(blankPosition1 + 1) == PuzzleCondition.T
          && surface.getPeaceCondition(blankPosition0 + 1) == PuzzleCondition.T
          && !((surface.isPeacePosition(blankPosition0 - 9) && surface.getPeaceCondition(blankPosition0 - 9) == PuzzleCondition.T)
          && (surface.isPeacePosition(blankPosition1 + 11) && surface.getPeaceCondition(blankPosition1 + 11) == PuzzleCondition.T))) {
        PuzzleSurface newSurface = new PuzzleSurface();
        newSurface.copy(surface);
        newSurface.setPeaceCondition(blankPosition0, PuzzleCondition.T);
        newSurface.setPeaceCondition(blankPosition1, PuzzleCondition.T);
        newSurface.setPeaceCondition(blankPosition0 + 1, PuzzleCondition.B);
        newSurface.setPeaceCondition(blankPosition1 + 1, PuzzleCondition.B);
        if (!problem.isAlready(newSurface)) {
          newSurface.setBeforePuzzleId(surface.getPuzzleId());
          leafList.add(newSurface);
          //        newSurface.print();
        }
      }
    }

  }

  /**
   * 空白が1マス分のときに移動可能なルートを列挙します。
   * @param problem
   * @param leafList
   * @param surface
   * @param blankPosition
   */
  private void moveBlankOne(PuzzleProblem problem, List<PuzzleSurface> leafList, PuzzleSurface surface, int blankPosition) {
    //上
    if (surface.isPeacePosition(blankPosition - 10)
        && surface.isPeacePosition(blankPosition - 10)
        && surface.getPeaceCondition(blankPosition - 10) == PuzzleCondition.S) {

      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.S);
      newSurface.setPeaceCondition(blankPosition - 10, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }

    } else if (surface.isPeacePosition(blankPosition - 20)
        && surface.getPeaceCondition(blankPosition - 10) == PuzzleCondition.T
        && surface.getPeaceCondition(blankPosition - 20) == PuzzleCondition.T) {
      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.T);
      //      newSurface.setPeaceCondition(blankPosition - 10, PuzzleCondition.T);
      newSurface.setPeaceCondition(blankPosition - 20, PuzzleCondition.B);

      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }
    }

    //下
    if (surface.isPeacePosition(blankPosition + 10)
        && surface.getPeaceCondition(blankPosition + 10) == PuzzleCondition.S) {

      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.S);
      newSurface.setPeaceCondition(blankPosition + 10, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }

    } else if (surface.isPeacePosition(blankPosition + 20)
        && surface.getPeaceCondition(blankPosition + 10) == PuzzleCondition.T
        && surface.getPeaceCondition(blankPosition + 20) == PuzzleCondition.T) {
      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.T);
      //      newSurface.setPeaceCondition(blankPosition + 10, PuzzleCondition.T);
      newSurface.setPeaceCondition(blankPosition + 20, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }
    }

    //左
    if (surface.isPeacePosition(blankPosition - 1)
        && surface.isPeacePosition(blankPosition - 1)
        && surface.getPeaceCondition(blankPosition - 1) == PuzzleCondition.S) {

      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.S);
      newSurface.setPeaceCondition(blankPosition - 1, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }

    } else if (surface.isPeacePosition(blankPosition - 2) &&
        surface.getPeaceCondition(blankPosition - 1) == PuzzleCondition.Y &&
        surface.getPeaceCondition(blankPosition - 2) == PuzzleCondition.Y) {
      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.Y);
      //      newSurface.setPeaceCondition(blankPosition - 1, PuzzleCondition.Y);
      newSurface.setPeaceCondition(blankPosition - 2, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }
    }

    //右
    if (surface.isPeacePosition(blankPosition + 1)
        && surface.getPeaceCondition(blankPosition + 1) == PuzzleCondition.S) {

      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.S);
      newSurface.setPeaceCondition(blankPosition + 1, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }

    } else if (surface.isPeacePosition(blankPosition + 2)
        && surface.getPeaceCondition(blankPosition + 1) == PuzzleCondition.Y
        && surface.getPeaceCondition(blankPosition + 2) == PuzzleCondition.Y) {
      PuzzleSurface newSurface = new PuzzleSurface();
      newSurface.copy(surface);
      newSurface.setPeaceCondition(blankPosition, PuzzleCondition.Y);
      //      newSurface.setPeaceCondition(blankPosition + 1, PuzzleCondition.Y);
      newSurface.setPeaceCondition(blankPosition + 2, PuzzleCondition.B);
      if (!problem.isAlready(newSurface)) {
        newSurface.setBeforePuzzleId(surface.getPuzzleId());
        leafList.add(newSurface);
        //        newSurface.print();
      }
    }

  }

}
