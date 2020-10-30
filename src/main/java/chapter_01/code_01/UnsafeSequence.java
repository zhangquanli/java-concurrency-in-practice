package chapter_01.code_01;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单 1-1 非线程安全的数值序列生成器
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * 返回一个唯一的值。
     */
    public int getNext() {
        return value++;
    }
}
