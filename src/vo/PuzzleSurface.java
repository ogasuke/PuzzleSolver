package vo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * パズルの盤面を表現します。 <br>
 * <br>
 * 11 12 13 14 <br>
 * 21 22 23 24 <br>
 * 31 32 33 34 <br>
 * 41 42 43 44 <br>
 * 51 52 53 54 <br>
 *
 * @author ogasawara
 */
public class PuzzleSurface {
  private int puzzleId;
  private int beforePuzzleId;
  private List<Integer> rootList = new ArrayList<Integer>();

  private PuzzleCondition puzzle1_1;
  private PuzzleCondition puzzle1_2;
  private PuzzleCondition puzzle1_3;
  private PuzzleCondition puzzle1_4;
  private PuzzleCondition puzzle2_1;
  private PuzzleCondition puzzle2_2;
  private PuzzleCondition puzzle2_3;
  private PuzzleCondition puzzle2_4;
  private PuzzleCondition puzzle3_1;
  private PuzzleCondition puzzle3_2;
  private PuzzleCondition puzzle3_3;
  private PuzzleCondition puzzle3_4;
  private PuzzleCondition puzzle4_1;
  private PuzzleCondition puzzle4_2;
  private PuzzleCondition puzzle4_3;
  private PuzzleCondition puzzle4_4;
  private PuzzleCondition puzzle5_1;
  private PuzzleCondition puzzle5_2;
  private PuzzleCondition puzzle5_3;
  private PuzzleCondition puzzle5_4;

  public int getPuzzleId() {
    return puzzleId;
  }

  public void setPuzzleId(int puzzleId) {
    this.puzzleId = puzzleId;
  }

  public int getBeforePuzzleId() {
    return beforePuzzleId;
  }

  public void setBeforePuzzleId(int beforePuzzleId) {
    this.beforePuzzleId = beforePuzzleId;
  }

  public List<Integer> getRootList() {
    return rootList;
  }

  public void setRoot(List<Integer> rootList) {
    this.rootList = rootList;
  }

  public PuzzleCondition getPuzzle1_1() {
    return puzzle1_1;
  }

  public void setPuzzle1_1(PuzzleCondition puzzle1_1) {
    this.puzzle1_1 = puzzle1_1;
  }

  public PuzzleCondition getPuzzle1_2() {
    return puzzle1_2;
  }

  public void setPuzzle1_2(PuzzleCondition puzzle1_2) {
    this.puzzle1_2 = puzzle1_2;
  }

  public PuzzleCondition getPuzzle1_3() {
    return puzzle1_3;
  }

  public void setPuzzle1_3(PuzzleCondition puzzle1_3) {
    this.puzzle1_3 = puzzle1_3;
  }

  public PuzzleCondition getPuzzle1_4() {
    return puzzle1_4;
  }

  public void setPuzzle1_4(PuzzleCondition puzzle1_4) {
    this.puzzle1_4 = puzzle1_4;
  }

  public PuzzleCondition getPuzzle2_1() {
    return puzzle2_1;
  }

  public void setPuzzle2_1(PuzzleCondition puzzle2_1) {
    this.puzzle2_1 = puzzle2_1;
  }

  public PuzzleCondition getPuzzle2_2() {
    return puzzle2_2;
  }

  public void setPuzzle2_2(PuzzleCondition puzzle2_2) {
    this.puzzle2_2 = puzzle2_2;
  }

  public PuzzleCondition getPuzzle2_3() {
    return puzzle2_3;
  }

  public void setPuzzle2_3(PuzzleCondition puzzle2_3) {
    this.puzzle2_3 = puzzle2_3;
  }

  public PuzzleCondition getPuzzle2_4() {
    return puzzle2_4;
  }

  public void setPuzzle2_4(PuzzleCondition puzzle2_4) {
    this.puzzle2_4 = puzzle2_4;
  }

  public PuzzleCondition getPuzzle3_1() {
    return puzzle3_1;
  }

  public void setPuzzle3_1(PuzzleCondition puzzle3_1) {
    this.puzzle3_1 = puzzle3_1;
  }

  public PuzzleCondition getPuzzle3_2() {
    return puzzle3_2;
  }

  public void setPuzzle3_2(PuzzleCondition puzzle3_2) {
    this.puzzle3_2 = puzzle3_2;
  }

  public PuzzleCondition getPuzzle3_3() {
    return puzzle3_3;
  }

  public void setPuzzle3_3(PuzzleCondition puzzle3_3) {
    this.puzzle3_3 = puzzle3_3;
  }

  public PuzzleCondition getPuzzle3_4() {
    return puzzle3_4;
  }

  public void setPuzzle3_4(PuzzleCondition puzzle3_4) {
    this.puzzle3_4 = puzzle3_4;
  }

  public PuzzleCondition getPuzzle4_1() {
    return puzzle4_1;
  }

  public void setPuzzle4_1(PuzzleCondition puzzle4_1) {
    this.puzzle4_1 = puzzle4_1;
  }

  public PuzzleCondition getPuzzle4_2() {
    return puzzle4_2;
  }

  public void setPuzzle4_2(PuzzleCondition puzzle4_2) {
    this.puzzle4_2 = puzzle4_2;
  }

  public PuzzleCondition getPuzzle4_3() {
    return puzzle4_3;
  }

  public void setPuzzle4_3(PuzzleCondition puzzle4_3) {
    this.puzzle4_3 = puzzle4_3;
  }

  public PuzzleCondition getPuzzle4_4() {
    return puzzle4_4;
  }

  public void setPuzzle4_4(PuzzleCondition puzzle4_4) {
    this.puzzle4_4 = puzzle4_4;
  }

  public PuzzleCondition getPuzzle5_1() {
    return puzzle5_1;
  }

  public void setPuzzle5_1(PuzzleCondition puzzle5_1) {
    this.puzzle5_1 = puzzle5_1;
  }

  public PuzzleCondition getPuzzle5_2() {
    return puzzle5_2;
  }

  public void setPuzzle5_2(PuzzleCondition puzzle5_2) {
    this.puzzle5_2 = puzzle5_2;
  }

  public PuzzleCondition getPuzzle5_3() {
    return puzzle5_3;
  }

  public void setPuzzle5_3(PuzzleCondition puzzle5_3) {
    this.puzzle5_3 = puzzle5_3;
  }

  public PuzzleCondition getPuzzle5_4() {
    return puzzle5_4;
  }

  public void setPuzzle5_4(PuzzleCondition puzzle5_4) {
    this.puzzle5_4 = puzzle5_4;
  }

  public void copy(PuzzleSurface surface) {
    this.rootList.addAll(surface.getRootList());
    this.puzzle1_1 = surface.getPuzzle1_1();
    this.puzzle1_2 = surface.getPuzzle1_2();
    this.puzzle1_3 = surface.getPuzzle1_3();
    this.puzzle1_4 = surface.getPuzzle1_4();
    this.puzzle2_1 = surface.getPuzzle2_1();
    this.puzzle2_2 = surface.getPuzzle2_2();
    this.puzzle2_3 = surface.getPuzzle2_3();
    this.puzzle2_4 = surface.getPuzzle2_4();
    this.puzzle3_1 = surface.getPuzzle3_1();
    this.puzzle3_2 = surface.getPuzzle3_2();
    this.puzzle3_3 = surface.getPuzzle3_3();
    this.puzzle3_4 = surface.getPuzzle3_4();
    this.puzzle4_1 = surface.getPuzzle4_1();
    this.puzzle4_2 = surface.getPuzzle4_2();
    this.puzzle4_3 = surface.getPuzzle4_3();
    this.puzzle4_4 = surface.getPuzzle4_4();
    this.puzzle5_1 = surface.getPuzzle5_1();
    this.puzzle5_2 = surface.getPuzzle5_2();
    this.puzzle5_3 = surface.getPuzzle5_3();
    this.puzzle5_4 = surface.getPuzzle5_4();
  }

  public boolean isSame(PuzzleSurface surface) {
    if (this.puzzle1_1 == surface.getPuzzle1_1()
        && this.puzzle1_2 == surface.getPuzzle1_2()
        && this.puzzle1_3 == surface.getPuzzle1_3()
        && this.puzzle1_4 == surface.getPuzzle1_4()
        && this.puzzle2_1 == surface.getPuzzle2_1()
        && this.puzzle2_2 == surface.getPuzzle2_2()
        && this.puzzle2_3 == surface.getPuzzle2_3()
        && this.puzzle2_4 == surface.getPuzzle2_4()
        && this.puzzle3_1 == surface.getPuzzle3_1()
        && this.puzzle3_2 == surface.getPuzzle3_2()
        && this.puzzle3_3 == surface.getPuzzle3_3()
        && this.puzzle3_4 == surface.getPuzzle3_4()
        && this.puzzle4_1 == surface.getPuzzle4_1()
        && this.puzzle4_2 == surface.getPuzzle4_2()
        && this.puzzle4_3 == surface.getPuzzle4_3()
        && this.puzzle4_4 == surface.getPuzzle4_4()
        && this.puzzle5_1 == surface.getPuzzle5_1()
        && this.puzzle5_2 == surface.getPuzzle5_2()
        && this.puzzle5_3 == surface.getPuzzle5_3()
        && this.puzzle5_4 == surface.getPuzzle5_4()) {
      return true;
    }
    return false;
  }

  public int getBlankCount() {
    int result = 0;

    if (puzzle1_1 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle1_2 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle1_3 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle1_4 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle2_1 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle2_2 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle2_3 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle2_4 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle3_1 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle3_2 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle3_3 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle3_4 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle4_1 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle4_2 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle4_3 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle4_4 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle5_1 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle5_2 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle5_3 == PuzzleCondition.B) {
      result++;
    }
    if (puzzle5_4 == PuzzleCondition.B) {
      result++;
    }
    return result;
  }

  public int[] getBlank() {
    int blank1 = 0;
    int blank2 = 0;
    if (puzzle1_1 == PuzzleCondition.B) {
      blank1 = 11;
    }
    if (puzzle1_2 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 12;
      } else {
        blank1 = 12;
      }
    }
    if (puzzle1_3 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 13;
      } else {
        blank1 = 13;
      }
    }
    if (puzzle1_4 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 14;
      } else {
        blank1 = 14;
      }
    }
    if (puzzle2_1 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 21;
      } else {
        blank1 = 21;
      }
    }
    if (puzzle2_2 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 22;
      } else {
        blank1 = 22;
      }
    }
    if (puzzle2_3 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 23;
      } else {
        blank1 = 23;
      }
    }
    if (puzzle2_4 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 24;
      } else {
        blank1 = 24;
      }
    }
    if (puzzle3_1 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 31;
      } else {
        blank1 = 31;
      }
    }
    if (puzzle3_2 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 32;
      } else {
        blank1 = 32;
      }
    }
    if (puzzle3_3 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 33;
      } else {
        blank1 = 33;
      }
    }
    if (puzzle3_4 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 34;
      } else {
        blank1 = 34;
      }
    }
    if (puzzle4_1 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 41;
      } else {
        blank1 = 41;
      }
    }
    if (puzzle4_2 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 42;
      } else {
        blank1 = 42;
      }
    }
    if (puzzle4_3 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 43;
      } else {
        blank1 = 43;
      }
    }
    if (puzzle4_4 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 44;
      } else {
        blank1 = 44;
      }
    }
    if (puzzle5_1 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 51;
      } else {
        blank1 = 51;
      }
    }
    if (puzzle5_2 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 52;
      } else {
        blank1 = 52;
      }
    }
    if (puzzle5_3 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 53;
      } else {
        blank1 = 53;
      }
    }
    if (puzzle5_4 == PuzzleCondition.B) {
      if (blank1 != 0) {
        blank2 = 54;
      } else {
        blank1 = 54;
      }
    }
    int[] value = { blank1, blank2 };
    return value;
  }

  public PuzzleCondition getPeaceCondition(int position) {
    switch (position) {
      case 11:
        return puzzle1_1;
      case 12:
        return puzzle1_2;
      case 13:
        return puzzle1_3;
      case 14:
        return puzzle1_4;
      case 21:
        return puzzle2_1;
      case 22:
        return puzzle2_2;
      case 23:
        return puzzle2_3;
      case 24:
        return puzzle2_4;
      case 31:
        return puzzle3_1;
      case 32:
        return puzzle3_2;
      case 33:
        return puzzle3_3;
      case 34:
        return puzzle3_4;
      case 41:
        return puzzle4_1;
      case 42:
        return puzzle4_2;
      case 43:
        return puzzle4_3;
      case 44:
        return puzzle4_4;
      case 51:
        return puzzle5_1;
      case 52:
        return puzzle5_2;
      case 53:
        return puzzle5_3;
      case 54:
        return puzzle5_4;
      default:
        throw new RuntimeException("指定した場所は定義されていません。");
    }
  }

  public void setPeaceCondition(int position, PuzzleCondition condition) {
    switch (position) {
      case 11:
        setPuzzle1_1(condition);
        break;
      case 12:
        setPuzzle1_2(condition);
        break;
      case 13:
        setPuzzle1_3(condition);
        break;
      case 14:
        setPuzzle1_4(condition);
        break;
      case 21:
        setPuzzle2_1(condition);
        break;
      case 22:
        setPuzzle2_2(condition);
        break;
      case 23:
        setPuzzle2_3(condition);
        break;
      case 24:
        setPuzzle2_4(condition);
        break;
      case 31:
        setPuzzle3_1(condition);
        break;
      case 32:
        setPuzzle3_2(condition);
        break;
      case 33:
        setPuzzle3_3(condition);
        break;
      case 34:
        setPuzzle3_4(condition);
        break;
      case 41:
        setPuzzle4_1(condition);
        break;
      case 42:
        setPuzzle4_2(condition);
        break;
      case 43:
        setPuzzle4_3(condition);
        break;
      case 44:
        setPuzzle4_4(condition);
        break;
      case 51:
        setPuzzle5_1(condition);
        break;
      case 52:
        setPuzzle5_2(condition);
        break;
      case 53:
        setPuzzle5_3(condition);
        break;
      case 54:
        setPuzzle5_4(condition);
        break;
      default:
        throw new RuntimeException("指定した場所は定義されていません。");
    }
  }

  public boolean isPeacePosition(int position) {
    switch (position) {
      case 11:
      case 12:
      case 13:
      case 14:
      case 21:
      case 22:
      case 23:
      case 24:
      case 31:
      case 32:
      case 33:
      case 34:
      case 41:
      case 42:
      case 43:
      case 44:
      case 51:
      case 52:
      case 53:
      case 54:
        return true;

      default:
        return false;
    }
  }

  public void print() {
    System.out.println("【パズル画面】");
    System.out.println(puzzle1_1.getDraw() + " , " + puzzle1_2.getDraw() + " , " + puzzle1_3.getDraw() + " , " + puzzle1_4.getDraw());
    System.out.println(puzzle2_1.getDraw() + " , " + puzzle2_2.getDraw() + " , " + puzzle2_3.getDraw() + " , " + puzzle2_4.getDraw());
    System.out.println(puzzle3_1.getDraw() + " , " + puzzle3_2.getDraw() + " , " + puzzle3_3.getDraw() + " , " + puzzle3_4.getDraw());
    System.out.println(puzzle4_1.getDraw() + " , " + puzzle4_2.getDraw() + " , " + puzzle4_3.getDraw() + " , " + puzzle4_4.getDraw());
    System.out.println(puzzle5_1.getDraw() + " , " + puzzle5_2.getDraw() + " , " + puzzle5_3.getDraw() + " , " + puzzle5_4.getDraw());
    System.out.println("");
  }

  public void print(FileWriter filewriter) throws IOException {
    filewriter.write("【パズル画面】\r\n");
    filewriter.write(puzzle1_1.getDraw() + " , " + puzzle1_2.getDraw() + " , " + puzzle1_3.getDraw() + " , " + puzzle1_4.getDraw() + "\r\n");
    filewriter.write(puzzle2_1.getDraw() + " , " + puzzle2_2.getDraw() + " , " + puzzle2_3.getDraw() + " , " + puzzle2_4.getDraw() + "\r\n");
    filewriter.write(puzzle3_1.getDraw() + " , " + puzzle3_2.getDraw() + " , " + puzzle3_3.getDraw() + " , " + puzzle3_4.getDraw() + "\r\n");
    filewriter.write(puzzle4_1.getDraw() + " , " + puzzle4_2.getDraw() + " , " + puzzle4_3.getDraw() + " , " + puzzle4_4.getDraw() + "\r\n");
    filewriter.write(puzzle5_1.getDraw() + " , " + puzzle5_2.getDraw() + " , " + puzzle5_3.getDraw() + " , " + puzzle5_4.getDraw() + "\r\n");
    filewriter.write("\r\n");

    for (int i : rootList) {
      filewriter.write(i + "⇒");
    }
    filewriter.write("\r\n");
  }
}
