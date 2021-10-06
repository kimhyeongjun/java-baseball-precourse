package baseball.core;

import baseball.enums.EventListenerId;
import baseball.vo.EventMessage;

public abstract class EventListener {

  private EventListenerId id;

  public EventListener(EventListenerId id) {
    this.id = id;
  }

  abstract public void onEvent(EventMessage message);

  public EventListenerId getId() {
    return id;
  }

}
