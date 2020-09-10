package chapter_07.code_16;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Logging service that uses an ExecutorService.
 */
public class LogService {
    private final ExecutorService exec;
    private final PrintWriter writer;

    public LogService(Writer writer) {
        this.exec = Executors.newSingleThreadExecutor();
        this.writer = new PrintWriter(writer);
    }

    public void start() {
    }

    public void stop() throws InterruptedException {
        try {
            exec.shutdown();
            exec.awaitTermination(30, TimeUnit.MINUTES);
        } finally {
            writer.close();
        }
    }

    public void log(String msg) {
        try {
            exec.execute(() -> writer.println(msg));
        } catch (RejectedExecutionException ignored) {
        }
    }
}
