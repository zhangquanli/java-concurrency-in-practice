package chapter_03.code_02;

import net.jcip.annotations.NotThreadSafe;

/**
 * Non-thread-safe mutable integer holder.
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
