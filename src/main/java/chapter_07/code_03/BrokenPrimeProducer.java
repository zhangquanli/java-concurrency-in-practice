package chapter_07.code_03;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 程序清单 7-3 不可靠的取消操作将把生产者置于阻塞的操作中（不要这么做）
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                p = p.nextProbablePrime();
                queue.put(p);
            }
        } catch (InterruptedException ignored) {
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
