package vo;

/**
 * パズルの状態を表現します。
 * @author ogasawara
 */
public enum PuzzleCondition {

  B("  ") //空白
  , S("小") //正方形(小)
  , T("縦") //長方形(縦)
  , Y("横") //長方形(横)
  , D("大"); //正方形(大)

  private PuzzleCondition(String draw) {
    this.draw = draw;
  }

  private String draw;

  public String getDraw() {
    return draw;
  }

}
