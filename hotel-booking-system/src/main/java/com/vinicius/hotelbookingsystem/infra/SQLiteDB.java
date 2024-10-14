package com.vinicius.hotelbookingsystem.infra;

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
    username TEXT NOT NULL UNIQUE,
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
    room_number TEXT NOT NULL UNIQUE,
    room_type TEXT NOT NULL,
    price REAL NOT NULL,
    available BOOLEAN DEFAULT TRUE
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

    public static void createBookingsTable() {

        String sql = """
CREATE TABLE IF NOT EXISTS bookings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    room_id INTEGER NOT NULL,
    customer_name TEXT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);
""";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();

            stmt.execute(sql);

            System.out.println("Bookings table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setupDatabase() {
        connect();
        createUsersTable();
        createRoomsTable();
        createBookingsTable();
    }
}
