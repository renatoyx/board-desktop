package br.com.dio.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:board_desktop.db");
    }
}