package chapter_07.code_07;

import java.util.concurrent.BlockingQueue;

/**
 * 程序清单 7-7 不可取消的任务在退出前恢复中断
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
                    // 重新尝试
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
