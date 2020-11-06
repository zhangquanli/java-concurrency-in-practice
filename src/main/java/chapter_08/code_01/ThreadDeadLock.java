package chapter_08.code_01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 程序清单 8-1 在单线程 Executor 中任务发生死锁（不要这么做）
 */
public class ThreadDeadLock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        public String call() throws Exception {
            // 在这里我们实际读取文件
            return "";
        }
    }

    public class RenderPageTask implements Callable<String> {
        public String call() throws Exception {
            Future<String> header = exec.submit(new LoadFileTask("header.html"));
            Future<String> footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // 将发生死锁——由于任务在等待子任务的结果
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            // 在这里我们实际渲染页面
            return "";
        }
    }
}
