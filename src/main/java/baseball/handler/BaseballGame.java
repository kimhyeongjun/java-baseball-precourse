package baseball.handler;

import baseball.vo.GameResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

  private final static int COUNT = 3;
  private final List<Integer> randomNumbers;
  private final GameResult gameResult;

  public BaseballGame() {
    this.gameResult = GameResult.builder().build();
    this.randomNumbers = new ArrayList<>(COUNT);
  }

  public void createNumbers() {
    for (int i = 0; i < COUNT; i++) {
      randomNumbers.add(i, getNumber());
    }
  }

  private int getNumber() {
    int num = Randoms.pickNumberInRange(1, 9);

    return randomNumbers.contains(num) ? getNumber() : num;
  }

}
