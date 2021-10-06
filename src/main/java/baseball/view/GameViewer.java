package baseball.view;

import baseball.controller.GameController;
import baseball.core.Event;
import baseball.core.EventListener;
import baseball.enums.EventId;
import baseball.enums.GameStatus;
import baseball.util.Printer;
import baseball.util.Validator;
import baseball.vo.EventMessage;
import nextstep.utils.Console;

import static baseball.enums.GameStatus.*;

public class GameViewer extends EventListener {

  private final Event event;

  public GameViewer() {
    super(EventId.GAME_VIEWER);
    this.event = new Event(EventId.GAME_CONTROLLER);
  }

  @Override
  public void onEvent(EventMessage message) {
    GameStatus gameStatus = message.getGameStatus();
    if (START == gameStatus) {
      playGame(gameStatus);
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

}
