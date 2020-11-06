package chapter_07.code_11;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 程序清单 7-11 通过改写 interrupt 方法将非标准的取消操作封装在 Thread 中
 */
public class ReaderThread extends Thread {
    private static final int BUF_SIZE = 512;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        } catch (IOException ignored) {
        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUF_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            // 允许线程退出
        }
    }

    public void processBuffer(byte[] buf, int count) {
    }
}
