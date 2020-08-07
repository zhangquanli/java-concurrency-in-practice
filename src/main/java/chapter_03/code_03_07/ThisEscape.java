package chapter_03.code_03_07;

/**
 * Implicitly allowing the this reference to escape.
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(this::doSomething);
    }

    private void doSomething(Event e) {
    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
