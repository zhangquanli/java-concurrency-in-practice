package chapter_06.code_05;

import java.util.concurrent.Executor;

/**
 * Executor that starts a new thread for each task.
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
