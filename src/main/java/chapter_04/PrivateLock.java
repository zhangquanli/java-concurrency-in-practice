package chapter_04;

public class PrivateLock {
    private final Object myLock = new Object();

    void someMethod() {
        synchronized (myLock) {

        }
    }
}