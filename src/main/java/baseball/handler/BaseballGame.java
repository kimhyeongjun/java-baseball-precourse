package baseball.handler;

import baseball.vo.GameResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

  private List<Integer> randomNumbers;
  private GameResult gameResult;
  private final int NUMBER_DIGIT;
  private boolean running = Boolean.FALSE;

  public BaseballGame(int digit) {
    this.NUMBER_DIGIT = digit;
  }

  public void init() {
    this.randomNumbers = new ArrayList<>(NUMBER_DIGIT);
    createNumbers();
  }

  private void createNumbers() {
    for (int i = 0; i < NUMBER_DIGIT; i++) {
      randomNumbers.add(i, getNumber());
    }
  }

  public GameResult doStart(int[] inputNums) {
    gameResult = GameResult.builder().build();

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

  public boolean isRunning() {
    if (gameResult == null) {
      return Boolean.FALSE;
    }

    return !gameResult.isAllStrike();
  }

}
