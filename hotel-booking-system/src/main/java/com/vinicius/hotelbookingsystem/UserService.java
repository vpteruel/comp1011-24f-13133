package com.vinicius.hotelbookingsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String DB_URL = "jdbc:sqlite:hotel_booking.db";

    public static boolean addUser(UserEntity user) {

        String checkUserSql = "SELECT COUNT(t.id) FROM users t WHERE t.username = ?";
        String insertUserSql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement checkStmt = conn.prepareStatement(checkUserSql);
            PreparedStatement insertStmt = conn.prepareStatement(insertUserSql);

            // check if the username already exists
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("User with the same username already exists.");
                return false;
            }

            // insert the new user
            insertStmt.setString(1, user.getUsername());
            insertStmt.setString(2, user.getPassword());
            insertStmt.executeUpdate();
            System.out.println("User added to the database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static UserEntity getUserByLogin(String username, String password) {

        String sql = "SELECT t.id FROM users t WHERE t.username = ? AND t.password = ?";

        try {

            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                return new UserEntity(id, username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
