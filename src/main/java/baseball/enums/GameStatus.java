package baseball.enums;

public enum GameStatus {
  START(1),
  END(2),
  RUNNING(3)
  ;

  private int status;

  GameStatus(int status) {
    this.status = status;
  }

  public static GameStatus of(int status) {
    return of(status, 0);
  }

  private static GameStatus of(int status, int index) {
    GameStatus[] gameStatuses = GameStatus.values();

    if (index >= gameStatuses.length) {
      return null;
    }

    GameStatus gameStatus = gameStatuses[index];
    return gameStatus.status == status ? gameStatus : of(status, ++index);
  }

}
