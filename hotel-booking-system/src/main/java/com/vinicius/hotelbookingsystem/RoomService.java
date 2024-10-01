package com.vinicius.hotelbookingsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private static final String DB_URL = "jdbc:sqlite:hotel_booking.db";

    public static void addRoom(Room room) {

        String sql = "INSERT INTO rooms(room_number, room_type, price) VALUES(?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());

            pstmt.executeUpdate();
            System.out.println("Room added to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editRoom(Room room) {

        String sql = "UPDATE rooms SET room_number=?, room_type=?, price=? WHERE id=?";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());
            pstmt.setInt(4, room.getId());

            pstmt.executeUpdate();
            System.out.println("Room edited to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRoom(Room room) {

        String sql = "DELETE FROM rooms WHERE id=?";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, room.getId());

            pstmt.executeUpdate();
            System.out.println("Room deleted to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Room> getAllRooms() {

        String sql = "SELECT t.id, t.room_number, t.room_type, t.price FROM rooms t";
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
