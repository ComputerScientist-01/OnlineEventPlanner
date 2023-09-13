package com.demo;

import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a database connection
            Connection connection = DBUtil.getConnection();

            // Create instances of UserDAO and UserService
            UserDAO userDAO = new UserDAOImpl(connection);
            UserService userService = new UserServiceImpl(userDAO);

            // Example: Creating a new user
            User newUser = new User();
            newUser.setFullName("John Doe");
            newUser.setUsername("johndoe");
            // Set other user attributes...

            userService.createUser(newUser);

            // Example: Retrieving a user by ID
            int userIdToRetrieve = 1;
            User retrievedUser = userService.getUserById(userIdToRetrieve);

            if (retrievedUser != null) {
                System.out.println("Retrieved User: " + retrievedUser.getFullName());
            } else {
                System.out.println("User not found.");
            }

            // Close the database connection when done
            DBUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
