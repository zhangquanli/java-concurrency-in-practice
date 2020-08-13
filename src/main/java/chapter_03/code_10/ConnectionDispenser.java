package chapter_03.code_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Using ThreadLocal to ensure thread confinement.
 */
public class ConnectionDispenser {
    private static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to acquire Connection, e");
        }
    });

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
