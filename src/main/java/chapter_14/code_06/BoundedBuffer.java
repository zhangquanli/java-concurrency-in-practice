package chapter_14.code_06;

import chapter_14.code_02.BaseBoundedBuffer;
import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单 14-6 使用条件队列实现的有界缓存
 */
@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    // 条件谓词：not-full（!isFull()）
    // 条件谓词：not-empty（!isEmpty()）

    public BoundedBuffer() {
        this(100);
    }

    public BoundedBuffer(int size) {
        super(size);
    }

    // 阻塞并直到：not-full
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    // 阻塞并直到：not-empty
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
