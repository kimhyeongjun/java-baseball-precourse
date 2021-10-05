package baseball.vo;

public class GameResult {

  private int strikeCount;
  private int ballCount;

  public void increaseStrikeCount() {
    strikeCount++;
  }

  public void increaseBallCount() {
    ballCount++;
  }

  public void setStrikeCount(int strikeCount) {
    this.strikeCount = strikeCount;
  }

  public void setBallCount(int ballCount) {
    this.ballCount = ballCount;
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
      gameResult.setStrikeCount(strikeCount);
      return this;
    }

    public GameResultBuilder ballCount(int ballCount) {
      gameResult.setBallCount(ballCount);
      return this;
    }

    public GameResult build() {
      return gameResult;
    }
  }
}