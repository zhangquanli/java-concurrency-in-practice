package chapter_07.code_03;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Unreliable cancellation that can leave producers stuck in a blocking operation.
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
