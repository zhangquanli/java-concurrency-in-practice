package chapter_03.code_08;

/**
 * 程序清单 3-8 使用工厂方法来防止 this 引用在构造过程中逸出
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
