package chapter_08.code_06;

import chapter_08.code_07.MyAppThread;

import java.util.concurrent.ThreadFactory;

/**
 * 程序清单 8-6 自定义的线程工厂
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
