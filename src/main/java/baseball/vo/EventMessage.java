package baseball.vo;

import baseball.enums.GameStatus;

public class EventMessage {

  private GameStatus gameStatus;
  private Object body;

  private EventMessage() {}
  private EventMessage(GameStatus gameStatus, Object body) {}

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public Object getBody() {
    return body;
  }

  public static EventMessageBuilder builder() {
    return new EventMessageBuilder(new EventMessage());
  }

  public static class EventMessageBuilder {

    private final EventMessage eventMessage;

    public EventMessageBuilder(EventMessage eventMessage) {
      this.eventMessage = eventMessage;
    }

    public EventMessageBuilder gameStatus(GameStatus gameStatus) {
      eventMessage.gameStatus = gameStatus;
      return this;
    }

    public EventMessageBuilder body(Object body) {
      eventMessage.body = body;
      return this;
    }

    public EventMessage build() {
      return eventMessage;
    }

  }

}
