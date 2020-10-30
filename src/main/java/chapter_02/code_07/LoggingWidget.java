package chapter_02.code_07;

/**
 * 程序清单 2-7 如果内置锁不是可重入的，那么这段代码将发生死锁
 */
public class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
