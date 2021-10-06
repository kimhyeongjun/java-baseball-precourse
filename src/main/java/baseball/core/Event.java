package baseball.core;

import baseball.enums.EventListenerId;
import baseball.vo.EventMessage;

public class Event {

  private final EventListenerId targetId;

  public Event(EventListenerId targetId) {
    this.targetId = targetId;
  }

  public void send(EventMessage eventMessage) {
    EventHandler.callEvent(targetId, eventMessage);
  }

}
