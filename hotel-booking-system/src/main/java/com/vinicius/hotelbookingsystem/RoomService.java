package com.vinicius.hotelbookingsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private static final String DB_URL = "jdbc:sqlite:hotel_booking.db";

    public static void addRoom(String roomNumber, String roomType, double price) {

        boolean availability = true;
        String sql = "INSERT INTO rooms(room_number, room_type, price, availability) VALUES(?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, roomNumber);
            pstmt.setString(2, roomType);
            pstmt.setDouble(3, price);
            pstmt.setBoolean(4, availability);

            pstmt.executeUpdate();
            System.out.println("Room added to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Room> getAllRooms() {

        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();

        try {

            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String roomNumber = rs.getString("room_number");
                String roomType = rs.getString("room_type");
                double price = rs.getDouble("price");

                Room room = new Room(id, roomNumber, roomType, price);
                rooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rooms;
    }
}
