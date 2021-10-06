package baseball.controller;

import baseball.core.Event;
import baseball.core.EventHandler;
import baseball.core.EventListener;
import baseball.enums.EventId;
import baseball.enums.GameStatus;
import baseball.handler.BaseballGame;
import baseball.util.Converter;
import baseball.vo.EventMessage;
import baseball.vo.GameBoard;

import static baseball.enums.GameStatus.*;

public class GameController extends EventListener {

  public static int BALL_COUNT = 3;
  private final BaseballGame baseballGame;
  private final GameBoard gameBoard;
  private final Event event;

  public GameController() {
    super(EventId.GAME_CONTROLLER);
    this.event = new Event(EventId.GAME_VIEWER);
    this.gameBoard = new GameBoard();
    this.baseballGame = new BaseballGame(BALL_COUNT, gameBoard);
  }

  @Override
  public void onEvent(EventMessage message) {
    GameStatus gameStatus = message.getGameStatus();
    startGame(gameStatus, message.getBody().toString());
  }

  private void startGame(GameStatus gameStatus, String baseBall) {
    if (START == gameStatus) {
      baseballGame.init();
    }

    playGame(baseBall);
  }

  private void playGame(final String baseBall) {
    gameBoard.init();
    baseballGame.doStart(Converter.convertStringToIntArr(baseBall));
    GameStatus gameStatus = gameBoard.isEnd() ? END : RUNNING;

    event.send(EventMessage.builder().gameStatus(gameStatus).body(gameBoard).build());
  }
}
