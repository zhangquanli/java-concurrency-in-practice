package chapter_03.code_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 程序清单 3-10 使用 ThreadLocal 来维持线程封闭性
 */
public class ConnectionDispenser {
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private static ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to acquire Connection, e");
        }
    });

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
