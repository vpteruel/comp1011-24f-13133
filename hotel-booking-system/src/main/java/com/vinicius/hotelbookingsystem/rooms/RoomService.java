package com.vinicius.hotelbookingsystem.rooms;

import com.vinicius.hotelbookingsystem.infra.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    public static void addRoom(RoomEntity room) {

        String sql = "INSERT INTO rooms(room_number, room_type, price, is_available) VALUES(?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());
            pstmt.setBoolean(4, room.getIsAvailable());

            pstmt.executeUpdate();
            System.out.println("Room added to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editRoom(RoomEntity room) {

        String sql = "UPDATE rooms SET room_number=?, room_type=?, price=?, is_available=? WHERE id=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());
            pstmt.setBoolean(4, room.getIsAvailable());
            pstmt.setInt(5, room.getId());

            pstmt.executeUpdate();
            System.out.println("Room edited to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRoom(RoomEntity room) {

        String sql = "DELETE FROM rooms WHERE id=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, room.getId());

            pstmt.executeUpdate();
            System.out.println("Room deleted to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<RoomEntity> getAllRooms() {

        String sql = "SELECT t.id, t.room_number, t.room_type, t.price, t.is_available FROM rooms t";
        List<RoomEntity> rooms = new ArrayList<>();

        try {

            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String roomNumber = rs.getString("room_number");
                String roomType = rs.getString("room_type");
                double price = rs.getDouble("price");
                boolean isAvailable = rs.getBoolean("is_available");

                RoomEntity room = new RoomEntity(id, roomNumber, roomType, price, isAvailable);
                rooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rooms;
    }

    public static List<RoomEntity> getAvailableRooms() {

        String sql = "SELECT t.id, t.room_number, t.room_type, t.price FROM rooms t WHERE t.is_available = TRUE";
        List<RoomEntity> availableRooms = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String roomNumber = rs.getString("room_number");
                String roomType = rs.getString("room_type");
                double price = rs.getDouble("price");

                RoomEntity room = new RoomEntity(id, roomNumber, roomType, price, true);
                availableRooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return availableRooms;
    }

    public static boolean bookRoom(
            int roomId,
            String customerName,
            LocalDate startDate,
            LocalDate endDate
    ) {

        String updateRoomSql = "UPDATE rooms SET is_available = false WHERE id = ? AND is_available = true";
        String insertBookingSql = "INSERT INTO bookings(room_id, customer_name, start_date, end_date) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement updateRoomStmt = null;
        PreparedStatement insertBookingStmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // start transaction

            // update room availability
            updateRoomStmt = conn.prepareStatement(updateRoomSql);
            updateRoomStmt.setInt(1, roomId);
            int rowsAffected = updateRoomStmt.executeUpdate();

            if (rowsAffected > 0) {
                // room was available and updated, proceed to insert booking
                insertBookingStmt = conn.prepareStatement(insertBookingSql);
                insertBookingStmt.setInt(1, roomId);
                insertBookingStmt.setString(2, customerName);
                insertBookingStmt.setDate(3, Date.valueOf(startDate));
                insertBookingStmt.setDate(4, Date.valueOf(endDate));
                insertBookingStmt.executeUpdate();

                conn.commit();
                System.out.println("Room " + roomId + " has been booked successfully.");
                return true;
            } else {
                System.out.println("Room " + roomId + " is not available for booking.");
                conn.rollback();
                return false;
            }

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error rolling back: " + rollbackEx.getMessage());
            }
            System.out.println("Error booking room: " + e.getMessage());
            return false;
        } finally {
            try {
                if (updateRoomStmt != null) {
                    updateRoomStmt.close();
                }
                if (insertBookingStmt != null) {
                    insertBookingStmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void markRoomAsBooked(int roomId) {

        String sql = "UPDATE rooms SET is_available = false WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, roomId);
            pstmt.executeUpdate();
            System.out.println("Room was marked as booked.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getAvailableRoomCount() {

        String sql = "SELECT COUNT(id) FROM rooms WHERE is_available = 1";

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public static int getBookedRoomCount() {
        String sql = "SELECT COUNT(id) FROM rooms WHERE is_available = 0";

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}
