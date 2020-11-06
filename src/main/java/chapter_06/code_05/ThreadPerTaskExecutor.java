package chapter_06.code_05;

import java.util.concurrent.Executor;

/**
 * 程序清单 6-5 为每个请求启动一个新线程的 Executor
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
