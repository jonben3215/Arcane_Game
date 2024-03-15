package csci.ooad.arcane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventBus {
    private static EventBus instance;
    private final Map<EventType, Set<IObserver>> observers = new HashMap<>();

    private EventBus() {
        for (EventType eventType : EventType.values()) {
            observers.put(eventType, new HashSet<>());
        }
    }
    public static synchronized EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    public void attach(IObserver observer, EventType eventType) {
        observers.get(eventType).add(observer);
    }

    public void postMessage(EventType eventType, String eventDescription) {
        if (observers.get(eventType) != null) {
            for (IObserver observer : observers.get(eventType)) {
                observer.update(eventDescription);
            }
        }
        // Notify listeners subscribed to all events
        if (observers.get(EventType.All) != null) {
            for (IObserver observer : observers.get(EventType.All)) {
                observer.update(eventDescription);
            }
        }
    }

}
