package baseball.handler;

import baseball.util.Validator;
import baseball.vo.GameBoard;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

  private List<Integer> baseBalls;
  private GameBoard gameBoard;
  private final int BALL_COUNT;

  public BaseballGame(int ballCount, GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.BALL_COUNT = ballCount;
  }

  public void init() {
    if (baseBalls != null) {
      baseBalls.clear();
    }

    baseBalls = new ArrayList<>(BALL_COUNT);
    createBaseBalls();
  }

  private void createBaseBalls() {
    for (int i = 0; i < BALL_COUNT; i++) {
      baseBalls.add(i, getNumber());
    }
  }

  public void doStart(final int[] inputBalls) {
    for (int i = 0; i < inputBalls.length; i++) {
      int ball = baseBalls.get(i);
      int inputBall = inputBalls[i];

      doCounting(ball, inputBall);
    }
  }

  private void doCounting(final int num, final int inputNum) {
    if (num == inputNum) {
      gameBoard.increaseStrikeCount();
      return;
    }

    if (baseBalls.contains(inputNum)) {
      gameBoard.increaseBallCount();
    }
  }

  private int getNumber() {
    int num = Randoms.pickNumberInRange(1, 9);

    return Validator.validateDuplicateList(num, baseBalls) ? getNumber() : num;
  }

}
