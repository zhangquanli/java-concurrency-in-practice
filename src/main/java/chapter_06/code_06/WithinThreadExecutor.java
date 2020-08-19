package chapter_06.code_06;

import java.util.concurrent.Executor;

/**
 * Executor that executes tasks synchronously in the calling thread.
 */
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable command) {
        command.run();
    }
}
