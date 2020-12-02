package chapter_14.code_04;

import chapter_14.code_02.BaseBoundedBuffer;
import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单 14-4 调用 GrumpyBoundedBuffer 的代码
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

class ExampleUsage {
    private GrumpyBoundedBuffer<String> buffer;
    private static final int SLEEP_GRANULARITY = 50;

    public ExampleUsage(GrumpyBoundedBuffer<String> buffer) {
        this.buffer = buffer;
    }

    void useBuffer() throws InterruptedException {
        while (true) {
            try {
                String item = buffer.take();
                // 对于 item 执行一些操作
                System.out.println(item);
                break;
            } catch (BufferEmptyException e) {
                Thread.sleep(SLEEP_GRANULARITY);
            }
        }
    }
}

class BufferFullException extends RuntimeException {
}

class BufferEmptyException extends RuntimeException {
}
