package chapter_04.code_01;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Simple thread-safe counter using the Java monitor pattern.
 */
@ThreadSafe
public class Counter {
    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
