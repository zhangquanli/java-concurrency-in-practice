package chapter_05.code_05_12;

import chapter_05.code_05_13.LaunderThrowable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Using FutureTask to preload data that is needed later.
 */
public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<>(this::loadProductInfo);
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                throw LaunderThrowable.launderThrowable(cause);
            }
        }
    }

    private ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }

    private interface ProductInfo {
    }

    private static class DataLoadException extends Exception {
    }
}
