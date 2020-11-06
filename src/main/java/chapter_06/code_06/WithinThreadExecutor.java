package chapter_06.code_06;

import java.util.concurrent.Executor;

/**
 * 程序清单 6-6 在调用线程中以同步方式执行所有任务的 Executor
 */
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable command) {
        command.run();
    }
}
