package baseball.core;

import baseball.enums.EventId;
import baseball.vo.EventMessage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventHandler {

  private static final List<EventListener> eventListeners = new CopyOnWriteArrayList<>(); 
  
  public static void addListener(EventListener eventListener) {
    if (!eventListeners.contains(eventListener)) {
      eventListeners.add(eventListener);
    }
  }

  public static void removeListener(EventListener eventListener) {
    eventListeners.remove(eventListener);
  }
  
  public static void callEvent(final EventId id, final EventMessage message) {
    checkEventListeners();
    EventListener eventListener = getEventListener(0, id);
    eventListener.onEvent(message);
  }

  private static void checkEventListeners() {
    if (eventListeners.isEmpty()) {
      throw new RuntimeException("Not exists EventListener.");
    }
  }

  private static EventListener getEventListener(int index, EventId id) {
    if (index >= eventListeners.size()) {
      throw new RuntimeException("Not matched EventListener.");
    }

    EventListener eventListener = eventListeners.get(index);

    if (eventListener.getId() == id) {
      return eventListener;
    }
    
    return getEventListener(++index, id);
  }

}
