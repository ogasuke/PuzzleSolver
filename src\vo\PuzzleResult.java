package vo;

/**
 * パズルの結果を表現します。
 * @author ogasawara
 */
public enum PuzzleResult {

  SUCCESS("成功！"),
  CONTINUE("途中で処理が終わりました。"),
  FAIRURE("全ルート探索しましたが、解けないです。");

  private PuzzleResult(String message) {
    this.message = message;
  }

  private String message;

  public String getMessage() {
    return message;
  }
}
