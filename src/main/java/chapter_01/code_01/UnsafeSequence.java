package chapter_01.code_01;

import net.jcip.annotations.NotThreadSafe;

/**
 * Non-thread-safe sequence generator.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Return a unique value.
     */
    public int getNext() {
        return value++;
    }
}
