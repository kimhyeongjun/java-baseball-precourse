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

  public GameResult doStart(int[] inputNums) {
    for (int i = 0; i < inputNums.length; i++) {
      int num = randomNumbers.get(i);
      int inputNum = inputNums[i];

      doCounting(num, inputNum);
    }

    return gameResult;
  }

  private void doCounting(int num, int inputNum) {
    if (num == inputNum) {
      gameResult.increaseStrikeCount();
      return;
    }

    if (randomNumbers.contains(inputNum)) {
      gameResult.increaseBallCount();
    }
  }

  private int getNumber() {
    int num = Randoms.pickNumberInRange(1, 9);

    return randomNumbers.contains(num) ? getNumber() : num;
  }

}
