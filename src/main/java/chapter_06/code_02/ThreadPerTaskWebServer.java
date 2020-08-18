package chapter_06.code_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Web server that starts a new thread for each request.
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
        // request-handling logic here
    }
}
