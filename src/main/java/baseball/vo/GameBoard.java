package baseball.vo;

import baseball.controller.GameController;

public class GameBoard {

  private int strikeCount;
  private int ballCount;

  public void init() {
    this.ballCount = 0;
    this.strikeCount = 0;
  }

  public void increaseStrikeCount() {
    strikeCount++;
  }

  public void increaseBallCount() {
    ballCount++;
  }

  public int getBallCount() {
    return ballCount;
  }

  public int getStrikeCount() {
    return strikeCount;
  }

  public boolean isComplete() {
    return strikeCount + ballCount == GameController.BALL_COUNT;
  }

  public String getHint() {
    StringBuilder resultMessage = new StringBuilder();
    if (ballCount == 0 && strikeCount == 0) {
      resultMessage.append("낫싱");
    }
    if (strikeCount > 0) {
      createHint(strikeCount, resultMessage, "스트라이크");
    }
    if (ballCount > 0) {
      createHint(ballCount, resultMessage, "볼");
    }
    return resultMessage.toString();
  }

  private void createHint(int count, StringBuilder message, String hint) {
    if (message.length() > 0) {
      message.append(" ");
    }

    message.append(count).append(hint);
  }

  public static GameBoardBuilder builder() {
    return new GameBoardBuilder(new GameBoard());
  }

  public static class GameBoardBuilder {

    private final GameBoard gameBoard;

    public GameBoardBuilder(GameBoard gameBoard) {
      this.gameBoard = gameBoard;
    }


    public GameBoardBuilder strikeCount(int strikeCount) {
      gameBoard.strikeCount = strikeCount;
      return this;
    }

    public GameBoardBuilder ballCount(int ballCount) {
      gameBoard.ballCount = ballCount;
      return this;
    }

    public GameBoard build() {
      return gameBoard;
    }
  }
}