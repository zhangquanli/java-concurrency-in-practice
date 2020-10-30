package chapter_03.code_02;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单 3-2 非线程安全的可变整数类
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
