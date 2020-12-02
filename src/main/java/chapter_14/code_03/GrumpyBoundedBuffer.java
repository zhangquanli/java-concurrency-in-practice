package chapter_14.code_03;

import chapter_14.code_02.BaseBoundedBuffer;
import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单 14-3 当不满足前提条件时，有界缓存不会执行相应的操作
 */
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer() {
        this(100);
    }

    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }
}

class BufferFullException extends RuntimeException {
}

class BufferEmptyException extends RuntimeException {
}