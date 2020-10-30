package chapter_03.code_07;

/**
 * 程序清单 3-7 隐式地使 this 引用逸出（不要这么做）
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
