package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import vo.PuzzleCondition;
import vo.PuzzleProblem;
import vo.PuzzleSurface;

/**
 * パズルを解く準備を行ないます。<br>
 * ・結果ファイル<br>
 * ・問題の取得<br>
 * @author ogasawara
 */
public class PuzzlePrepareAction {

  protected FileWriter resultFileInit(String resultFileName) throws IOException {
    File file = new File(resultFileName);

    FileWriter filewriter = new FileWriter(file);
    checkBeforeWritefile(file);
    filewriter = new FileWriter(file);
    return filewriter;

  }

  private void checkBeforeWritefile(File file) throws IOException {
    if (file.exists()) {
      if (file.isFile() && file.canWrite()) {
        file.delete();
        file.createNewFile();
      }
    } else {
      file.createNewFile();
    }
  }

  /**
   * CSVファイルから問題のパズル情報を取得します。<br>
   * 空白マスが２マスでないとき、例外処理します。
   * @param csvPazzle
   * @param latestLeafId
   * @return
   * @throws IOException
   */
  protected PuzzleProblem prepareProblemPazzle(String problemFileName, int latestLeafId) throws IOException {

    PuzzleProblem problem = new PuzzleProblem();
    PuzzleSurface surface = new PuzzleSurface();
    surface.setPuzzleId(latestLeafId);
    try {
      File csv = new File(problemFileName); // CSVデータファイル

      BufferedReader br = new BufferedReader(new FileReader(csv));

      // 最終行まで読み込む
      String line = "";
      line = br.readLine();
      StringTokenizer st1 = new StringTokenizer(line, ",");
      surface.setPuzzle1_1(PuzzleCondition.valueOf(st1.nextToken()));
      surface.setPuzzle1_2(PuzzleCondition.valueOf(st1.nextToken()));
      surface.setPuzzle1_3(PuzzleCondition.valueOf(st1.nextToken()));
      surface.setPuzzle1_4(PuzzleCondition.valueOf(st1.nextToken()));
      line = br.readLine();
      StringTokenizer st2 = new StringTokenizer(line, ",");
      surface.setPuzzle2_1(PuzzleCondition.valueOf(st2.nextToken()));
      surface.setPuzzle2_2(PuzzleCondition.valueOf(st2.nextToken()));
      surface.setPuzzle2_3(PuzzleCondition.valueOf(st2.nextToken()));
      surface.setPuzzle2_4(PuzzleCondition.valueOf(st2.nextToken()));

      line = br.readLine();
      StringTokenizer st3 = new StringTokenizer(line, ",");
      surface.setPuzzle3_1(PuzzleCondition.valueOf(st3.nextToken()));
      surface.setPuzzle3_2(PuzzleCondition.valueOf(st3.nextToken()));
      surface.setPuzzle3_3(PuzzleCondition.valueOf(st3.nextToken()));
      surface.setPuzzle3_4(PuzzleCondition.valueOf(st3.nextToken()));

      line = br.readLine();
      StringTokenizer st4 = new StringTokenizer(line, ",");
      surface.setPuzzle4_1(PuzzleCondition.valueOf(st4.nextToken()));
      surface.setPuzzle4_2(PuzzleCondition.valueOf(st4.nextToken()));
      surface.setPuzzle4_3(PuzzleCondition.valueOf(st4.nextToken()));
      surface.setPuzzle4_4(PuzzleCondition.valueOf(st4.nextToken()));

      line = br.readLine();
      StringTokenizer st5 = new StringTokenizer(line, ",");
      surface.setPuzzle5_1(PuzzleCondition.valueOf(st5.nextToken()));
      surface.setPuzzle5_2(PuzzleCondition.valueOf(st5.nextToken()));
      surface.setPuzzle5_3(PuzzleCondition.valueOf(st5.nextToken()));
      surface.setPuzzle5_4(PuzzleCondition.valueOf(st5.nextToken()));

      br.close();

    } catch (FileNotFoundException e) {
      // Fileオブジェクト生成時の例外捕捉
      System.out.println("ファイルが見つかりませんでした。");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("ファイルの処理通のエラーです");
      // BufferedReaderオブジェクトのクローズ時の例外捕捉
      e.printStackTrace();
    }

    if (surface.getBlankCount() != 2) {
      throw new RuntimeException("問題のパズルで空白は、２マスに指定してください");
    }
    surface.getRootList().add(latestLeafId);
    surface.print();
    //    surface.print(filewriter);
    problem.setSurface(surface);
    problem.getLeafList().add(latestLeafId);
    problem.getPuzzleSurfaceMap().put(latestLeafId, surface);
    int[] val = { latestLeafId, latestLeafId };
    problem.getRootList().add(val);
    return problem;

  }
}
