package baseball.domain;

import baseball.vo.GameBoard;

public class BaseballGame {

  private final Computer computer;
  private final GameBoard gameBoard;

  public BaseballGame(GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.computer = new Computer();
  }

  public void init() {
    computer.init();
    computer.createBaseBalls();
  }

  public void doStart(final int[] inputBalls) {
    for (int i = 0; i < inputBalls.length; i++) {
      int ball = computer.getBaseBalls().get(i);
      int inputBall = inputBalls[i];

      doCounting(ball, inputBall);
    }
  }

  private void doCounting(final int num, final int inputNum) {
    if (num == inputNum) {
      gameBoard.increaseStrikeCount();
      return;
    }

    if (computer.getBaseBalls().contains(inputNum)) {
      gameBoard.increaseBallCount();
    }
  }

}
