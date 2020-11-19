package chapter_13.code_04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 程序清单 13-4 带有时间限制的加锁
 */
public class TimedLocking {
    private Lock lock = new ReentrantLock();

    public boolean trySendOnSharedLine(String message, long timeout, TimeUnit unit)
            throws InterruptedException {
        long nanosToLock = unit.toNanos(timeout) - estimatedNanosToSend(message);
        if (!lock.tryLock(nanosToLock, TimeUnit.NANOSECONDS)) {
            return false;
        }
        try {
            return sendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean sendOnSharedLine(String message) {
        return true;
    }

    long estimatedNanosToSend(String message) {
        return message.length();
    }
}
