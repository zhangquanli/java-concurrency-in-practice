package chapter_03.code_03_08;

/**
 * Using a factory method to prevent the this reference from escaping during construction.
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = this::doSomething;
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
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
