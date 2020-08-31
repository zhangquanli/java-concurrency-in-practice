package chapter_07.code_07;

import java.util.concurrent.BlockingQueue;

/**
 * Noncancelable task that restores interruption before exit.
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
