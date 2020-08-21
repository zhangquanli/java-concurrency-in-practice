package chapter_06.code_12;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Default implementation of newTaskFor in ThreadPoolExecutor. (See JDK source)
 */
public class ThreadPoolExecutor {
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> task) {
        return new FutureTask<>(task);
    }
}
