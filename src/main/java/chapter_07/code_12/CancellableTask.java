package chapter_07.code_12;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}
