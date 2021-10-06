package baseball;

import baseball.controller.GameController;
import baseball.core.EventHandler;
import baseball.enums.EventListenerId;
import baseball.enums.GameStatus;
import baseball.view.GameViewer;
import baseball.vo.EventMessage;

public class Application {

    public static void main(String[] args) {
        EventHandler.addListener(new GameViewer());
        EventHandler.addListener(new GameController());
        EventHandler.callEvent(EventListenerId.GAME_VIEWER, EventMessage.builder().gameStatus(GameStatus.START).build());
    }
}
