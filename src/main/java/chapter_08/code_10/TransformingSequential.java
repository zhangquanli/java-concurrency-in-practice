package chapter_08.code_10;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * 程序清单 8-10 将串行执行转换为并行执行
 */
public abstract class TransformingSequential {

    public abstract void process(Element element);

    void processSequentially(List<Element> elements) {
        for (final Element element : elements) {
            process(element);
        }
    }

    void processInParallel(Executor exec, List<Element> elements) {
        for (Element element : elements) {
            exec.execute(() -> process(element));
        }
    }

    public <T> void sequentiallyRecursive(List<Node<T>> nodes, Collection<T> results) {
        for (Node<T> node : nodes) {
            results.add(node.compute());
            sequentiallyRecursive(node.getChildren(), results);
        }
    }

    public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final Collection<T> results) {
        for (final Node<T> node : nodes) {
            exec.execute(() -> results.add(node.compute()));
            parallelRecursive(exec, node.getChildren(), results);
        }
    }

    public <T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Queue<T> resultQueue = new ConcurrentLinkedQueue<>();
        parallelRecursive(exec, nodes, resultQueue);
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }

    interface Element {
    }

    interface Node<T> {
        T compute();

        List<Node<T>> getChildren();
    }
}
