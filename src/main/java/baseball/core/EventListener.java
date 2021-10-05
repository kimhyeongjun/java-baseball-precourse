package baseball.core;

import baseball.enums.EventId;
import baseball.vo.EventMessage;

public abstract class EventListener {

  private EventId id;

  public EventListener(EventId id) {
    this.id = id;
  }

  abstract public void onEvent(EventMessage message);

  public EventId getId() {
    return id;
  }

}
