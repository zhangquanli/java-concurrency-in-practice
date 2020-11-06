package chapter_06.code_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 程序清单 6-2 在 Web 服务器中为每个请求启动一个新的线程（不要这么做）
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
    }
}
