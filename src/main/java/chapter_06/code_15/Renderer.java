package chapter_06.code_15;

import chapter_05.code_13.LaunderThrowable;

import java.util.List;
import java.util.concurrent.*;

/**
 * 程序清单 6-15 使用 CompletionService，使页面元素在下载完成后立即显示出来
 */
public abstract class Renderer {
    private final ExecutorService executor;

    Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
        for (ImageInfo imageInfo : imageInfos) {
            completionService.submit(imageInfo::downloadImage);
        }
        renderText(source);
        try {
            for (int t = 0; t < imageInfos.size(); t++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }
    }

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderText(CharSequence s);

    abstract void renderImage(ImageData i);

    interface ImageInfo {
        ImageData downloadImage();
    }

    interface ImageData {
    }
}
