package vo;

/**
 * �p�Y���̏�Ԃ�\�����܂��B
 * @author ogasawara
 */
public enum PuzzleCondition {

  B("  ") //��
  , S("��") //�����`(��)
  , T("�c") //�����`(�c)
  , Y("��") //�����`(��)
  , D("��"); //�����`(��)

  private PuzzleCondition(String draw) {
    this.draw = draw;
  }

  private String draw;

  public String getDraw() {
    return draw;
  }

}
