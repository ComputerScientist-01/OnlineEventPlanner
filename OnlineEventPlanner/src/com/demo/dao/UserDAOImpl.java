package com.demo.dao;

import com.demo.model.User;
import com.demo.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public User findById(long userId) {
        User user = null;
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = mapResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (full_name, username, password, date_of_joining, date_of_birth, " +
                "department, mobile, email, location, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, user.getDateOfJoining(), null);
            preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getDepartment());
            preparedStatement.setString(7, user.getMobile());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getLocation());
            preparedStatement.setString(10, user.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET full_name=?, username=?, password=?, date_of_joining=?, " +
                "date_of_birth=?, department=?, mobile=?, email=?, location=?, status=? WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, user.getDateOfJoining());
            preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getDepartment());
            preparedStatement.setString(7, user.getMobile());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getLocation());
            preparedStatement.setString(10, user.getStatus());
            preparedStatement.setLong(11, user.getUserId()); // Set the user_id for the WHERE clause
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(long userId) {
        String query = "DELETE FROM users WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong("user_id"));
        user.setFullName(resultSet.getString("full_name"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setDateOfJoining(resultSet.getDate("date_of_joining"));
        user.setDateOfBirth(resultSet.getDate("date_of_birth"));
        user.setDepartment(resultSet.getString("department"));
        user.setMobile(resultSet.getString("mobile"));
        user.setEmail(resultSet.getString("email"));
        user.setLocation(resultSet.getString("location"));
        user.setStatus(resultSet.getString("status"));
        return user;
    }
}
