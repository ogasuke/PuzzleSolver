package vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �p�Y���̖���\�����܂��B <br>
 *
 * @author ogasawara
 */
public class PuzzleProblem {

  private PuzzleSurface surface;

  /**
   * ID�Ɖ�ʂ̃}�b�s���O
   */
  private Map<Integer, PuzzleSurface> puzzleSurfaceMap = new HashMap<Integer, PuzzleSurface>();

  /**
   * ��Ԗ��[��ID�̃��X�g
   */
  private List<Integer> leafList = new ArrayList<Integer>();

  public PuzzleSurface getSurface() {
    return surface;
  }

  public void setSurface(PuzzleSurface surface) {
    this.surface = surface;
  }

  public Map<Integer, PuzzleSurface> getPuzzleSurfaceMap() {
    return puzzleSurfaceMap;
  }

  public void setPuzzleSurfaceMap(Map<Integer, PuzzleSurface> puzzleRootMap) {
    this.puzzleSurfaceMap = puzzleRootMap;
  }

  public List<Integer> getLeafList() {
    return leafList;
  }

  public void setLeafList(List<Integer> leafList) {
    this.leafList = leafList;
  }

  public boolean isAlready(PuzzleSurface surface) {
    boolean isAlready = false;
    for (PuzzleSurface vo : puzzleSurfaceMap.values()) {
      if (vo.isSame(surface)) {
        isAlready = true;
        break;
      }
    }
    return isAlready;
  }

  //  public String toString() {
  //    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  //  }
}
