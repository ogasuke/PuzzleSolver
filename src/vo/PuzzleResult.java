package vo;

/**
 * �p�Y���̌��ʂ�\�����܂��B
 * @author ogasawara
 */
public enum PuzzleResult {

  SUCCESS("�����I"),
  CONTINUE("�r���ŏ������I���܂����B"),
  FAIRURE("�S���[�g�T�����܂������A�����Ȃ��ł��B");

  private PuzzleResult(String message) {
    this.message = message;
  }

  private String message;

  public String getMessage() {
    return message;
  }
}
