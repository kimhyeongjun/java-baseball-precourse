package baseball.core;

import baseball.enums.EventId;
import baseball.vo.EventMessage;

public class Event {

  private final EventId targetId;

  public Event(EventId targetId) {
    this.targetId = targetId;
  }

  public void send(EventMessage eventMessage) {
    EventHandler.callEvent(targetId, eventMessage);
  }

}
