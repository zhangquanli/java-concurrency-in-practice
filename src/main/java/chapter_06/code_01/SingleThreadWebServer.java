package chapter_06.code_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 程序清单 6-1 串行的 Web 服务器
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
    }
}
