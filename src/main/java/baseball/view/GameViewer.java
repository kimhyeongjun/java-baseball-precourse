package baseball.view;

import baseball.controller.GameController;
import baseball.core.EventHandler;
import baseball.core.EventListener;
import baseball.core.Event;
import baseball.enums.EventListenerId;
import baseball.enums.GameStatus;
import baseball.util.Printer;
import baseball.util.Validator;
import baseball.vo.EventMessage;
import baseball.vo.GameBoard;
import nextstep.utils.Console;

import static baseball.enums.GameStatus.*;

public class GameViewer extends EventListener {

  private final Event event;

  public GameViewer() {
    super(EventListenerId.GAME_VIEWER);
    this.event = new Event(EventListenerId.GAME_CONTROLLER);
  }

  @Override
  public void onEvent(EventMessage message) {
    GameStatus gameStatus = message.getGameStatus();
    if (START == gameStatus) {
      playGame(gameStatus);
      return;
    }
    doNextStep(gameStatus, (GameBoard) message.getBody());
  }

  private void doNextStep(GameStatus gameStatus, GameBoard gameBoard) {
    Printer.println(gameBoard.getHint());
    if (RUNNING == gameStatus) {
      playGame(gameStatus);
      return;
    }
    if (COMPLETE == gameStatus) {
      doCompleteProcess();
    }
  }

  private void playGame(GameStatus gameStatus) {
    String numberStr = requestInput();

    if (!Validator.checkInput(numberStr)) {
      Printer.printf("[ERROR] %d자리의 숫자만 입력 가능합니다.", GameController.BALL_COUNT);
      playGame(gameStatus);
    }

    event.send(EventMessage.builder().gameStatus(gameStatus).body(numberStr).build());
  }

  private String requestInput() {
    Printer.print("숫자를 입력해주세요. : ");
    return Console.readLine();
  }

  private void doCompleteProcess() {
    Printer.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    if (confirmEndGame()) {
      callEndProcess();
      return;
    }
    playGame(START);
  }

  private boolean confirmEndGame() {
    GameStatus gameStatus = GameStatus.of(askRestartOrEndGame());

    if (gameStatus == null) {
      throw new IllegalStateException("Unexpected value");
    }

    return gameStatus == END;
  }

  private void callEndProcess() {
    event.send(EventMessage.builder().gameStatus(GameStatus.END).build());
    EventHandler.removeListener(this);
    Printer.println("게임을 종료합니다.");
  }

  private int askRestartOrEndGame() {
    Printer.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String commend = Console.readLine();
    return Integer.parseInt(commend);
  }

}
