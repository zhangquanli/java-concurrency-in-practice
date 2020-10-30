package chapter_04.code_03;

import net.jcip.annotations.GuardedBy;

/**
 * 程序清单 4-3 通过一个私有锁来保护状态
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // 访问或修改 Widget 的状态
        }
    }

    private static class Widget {
    }
}
