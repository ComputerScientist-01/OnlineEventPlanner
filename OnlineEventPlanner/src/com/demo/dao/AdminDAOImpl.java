package com.demo.dao;

import com.demo.model.Admin;
import com.demo.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {

    private Connection connection;

    public AdminDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public Admin findById(long adminId) {
        Admin admin = null;
        String query = "SELECT * FROM admins WHERE admin_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, adminId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = mapResultSetToAdmin(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin findByUsername(String username) {
        Admin admin = null;
        String query = "SELECT * FROM admins WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = mapResultSetToAdmin(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    private Admin mapResultSetToAdmin(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminId(resultSet.getLong("admin_id"));
        admin.setUsername(resultSet.getString("username"));
        admin.setFullName(resultSet.getString("full_name"));
        admin.setPassword(resultSet.getString("password"));
        admin.setEmail(resultSet.getString("email"));
        admin.setMobile(resultSet.getString("mobile"));
        // Map other fields as needed
        return admin;
    }
}
