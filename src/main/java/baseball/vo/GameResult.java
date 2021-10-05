package baseball.vo;

import baseball.controller.GameController;

public class GameResult {

  private int strikeCount;
  private int ballCount;
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

  public boolean isEnd() {
    return strikeCount + ballCount == GameController.GAME_COUNT;
  }

  public String getHint() {
    StringBuilder resultMessage = new StringBuilder();
    if (strikeCount > 0) {
      createHint(strikeCount, resultMessage);
      resultMessage.append("스트라이크");
    }
    if (ballCount > 0) {
      createHint(ballCount, resultMessage);
      resultMessage.append("볼");
    }
    return resultMessage.toString();
  }

  private void createHint(int count, StringBuilder message) {
    if (message.length() > 0) {
      message.append(" ");
    }

    message.append(count);
  }

  public static GameResultBuilder builder() {
    return new GameResultBuilder(new GameResult());
  }

  public static class GameResultBuilder {

    private final GameResult gameResult;

    public GameResultBuilder(GameResult gameResult) {
      this.gameResult = gameResult;
    }


    public GameResultBuilder strikeCount(int strikeCount) {
      gameResult.strikeCount = strikeCount;
      return this;
    }

    public GameResultBuilder ballCount(int ballCount) {
      gameResult.ballCount = ballCount;
      return this;
    }

    public GameResult build() {
      return gameResult;
    }
  }
}