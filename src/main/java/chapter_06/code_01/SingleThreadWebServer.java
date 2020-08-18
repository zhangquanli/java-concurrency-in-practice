package chapter_06.code_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Sequential web server.
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handlerRequest(connection);
        }
    }

    private static void handlerRequest(Socket connection) {
        // request-handling logic here
    }
}
