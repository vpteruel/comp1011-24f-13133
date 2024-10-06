package com.vinicius.hotelbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDB {

    private static final String DB_URL = "jdbc:sqlite:hotel_booking.db";

    public static void connect() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to SQLite database");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createUsersTable() {

        String sql = """
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);""";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();

            stmt.execute(sql);

            System.out.println("Users table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createRoomsTable() {

        String sql = """
CREATE TABLE IF NOT EXISTS rooms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    room_number TEXT NOT NULL,
    room_type TEXT NOT NULL,
    price REAL NOT NULL
);""";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();

            stmt.execute(sql);

            System.out.println("Rooms table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setupDatabase() {
        connect();
        createUsersTable();
        createRoomsTable();
    }
}
