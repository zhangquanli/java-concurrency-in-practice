package chapter_07.code_05;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 程序清单 7-5 通过中断来取消
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                queue.put(p);
            }
        } catch (InterruptedException e) {
            // Allow thread to exit
        }
    }

    public void cancel() {
        interrupt();
    }
}
