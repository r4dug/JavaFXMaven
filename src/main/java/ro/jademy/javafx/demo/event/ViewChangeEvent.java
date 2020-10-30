package ro.jademy.javafx.demo.event;

import javafx.event.Event;
import javafx.event.EventType;

public class ViewChangeEvent extends Event {

    public static final EventType<ViewChangeEvent> DASHBOARD = new EventType<>(Event.ANY, "DASHBOARD");
    public static final EventType<ViewChangeEvent> USERS = new EventType<>(Event.ANY, "USERS");
    public static final EventType<ViewChangeEvent> TABLE_VIEW = new EventType<>(Event.ANY, "TABLE_VIEW");

    public ViewChangeEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
