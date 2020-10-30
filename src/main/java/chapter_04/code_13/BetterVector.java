package chapter_04.code_13;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

/**
 * 程序清单 4-13 扩展 Vector 并增加一个 “若没有则添加” 方法
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    private static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
