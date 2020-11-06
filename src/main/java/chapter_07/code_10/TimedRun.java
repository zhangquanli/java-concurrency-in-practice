package chapter_07.code_10;

import chapter_05.code_13.LaunderThrowable;

import java.util.concurrent.*;

/**
 * 程序清单 7-10 通过 Future 来取消任务
 */
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // 接下来任务将被取消
        } catch (ExecutionException e) {
            // 如果在任务中抛出了异常，那么重新抛出该异常
            throw LaunderThrowable.launderThrowable(e.getCause());
        } finally {
            // 如果任务已结束，那么执行取消操作也不会带来任何影响
            task.cancel(true); // 如果任务正在运行，那么将被中断
        }
    }
}
