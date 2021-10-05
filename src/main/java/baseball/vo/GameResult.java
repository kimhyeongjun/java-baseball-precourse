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

  public int getBallCount() {
    return ballCount;
  }

  public int getStrikeCount() {
    return strikeCount;
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