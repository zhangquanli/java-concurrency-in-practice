package chapter_07.code_07;

import java.util.concurrent.BlockingQueue;

/**
 * 程序清单 7-6 将 InterruptedException 传递给调用者
 */
public class NoncancelableTask {
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (!interrupted) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // fall through and retry
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    interface Task {
    }
}
