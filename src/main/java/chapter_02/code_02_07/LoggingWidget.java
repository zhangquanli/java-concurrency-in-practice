package chapter_02.code_02_07;

/**
 * Code that would deadlock if intrinsic locks were not reentrant.
 */
public class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
