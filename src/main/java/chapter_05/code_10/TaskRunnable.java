package chapter_05.code_10;

import java.util.concurrent.BlockingQueue;

/**
 * 程序清单 5-10 恢复中断状态以避免屏蔽中断
 */
public class TaskRunnable implements Runnable {
    BlockingQueue<Task> queue;

    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // 恢复被中断的状态
            Thread.currentThread().interrupt();
        }
    }

    void processTask(Task task) {
    }

    interface Task {
    }
}
