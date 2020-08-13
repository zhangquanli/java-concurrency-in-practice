package chapter_04.code_03;

/**
 * Guarding state with a private lock.
 */
public class PrivateLock {
    private final Object myLock = new Object();

    void someMethod() {
        synchronized (myLock) {

        }
    }
}
