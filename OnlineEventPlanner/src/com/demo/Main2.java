package com.demo;
import com.demo.dao.AdminDAO;
import com.demo.dao.AdminDAOImpl;
import com.demo.dao.UserDAO;
import com.demo.dao.UserDAOImpl;
import com.demo.dao.VendorDAO;
import com.demo.dao.VendorDAOImpl;
import com.demo.db.DBUtil;
import com.demo.model.Admin;
import com.demo.model.User;
import com.demo.model.Vendor;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import com.demo.service.VendorService;
import com.demo.service.VendorServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Get a database connection
            Connection connection = DBUtil.getConnection();

            // Create instances of DAO and Service classes
            UserDAO userDAO = new UserDAOImpl();
            //UserDAO userDAO = new UserDAOImpl(connection);
            UserService userService = new UserServiceImpl(userDAO);
            
            VendorDAO vendorDAO = new VendorDAOImpl();
            //VendorDAO vendorDAO = new VendorDAOImpl(connection);
            VendorService vendorService = new VendorServiceImpl(vendorDAO);

            AdminDAO adminDAO = new AdminDAOImpl();
            //AdminDAO adminDAO = new AdminDAOImpl(connection);
            AdminService adminService = new AdminServiceImpl(adminDAO);

            // Implement the main menu for admin, vendor, and user actions
            while (true) {
                System.out.println("Main Menu:");
                System.out.println("1. Admin");
                System.out.println("2. Vendor");
                System.out.println("3. User");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        adminActions(adminService, userService, vendorService);
                        break;
                    case 2:
                        vendorActions(vendorService);
                        break;
                    case 3:
                        userActions(userService, vendorService);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        DBUtil.closeConnection();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void adminActions(AdminService adminService, UserService userService, VendorService vendorService) {
        // Implement admin actions here
        System.out.println("Admin Actions:");
        System.out.println("1. Add Vendor");
        System.out.println("2. View Vendors");
        System.out.println("3. View Users");
        System.out.println("4. Validate Login Details");
        System.out.println("5. Update User Status");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Implement add vendor
                break;
            case 2:
                // Implement view vendors
                List<Vendor> vendors = vendorService.getAllVendors();
                for (Vendor vendor : vendors) {
                    System.out.println(vendor);
                }
                break;
            case 3:
                // Implement view users
                List<User> users = userService.getAllUsers();
                for (User user : users) {
                    System.out.println(user);
                }
                break;
            case 4:
                // Implement validate login details
                break;
            case 5:
                // Implement update user status
                break;
            case 6:
                // Back to Main Menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void vendorActions(VendorService vendorService) {
        // Implement vendor actions here
        System.out.println("Vendor Actions:");
        System.out.println("1. Validate Login Details");
        System.out.println("2. Add Package");
        System.out.println("3. View Plan Requests");
        System.out.println("4. Create Quotation");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Implement validate login details
                break;
            case 2:
                // Implement add package
                break;
            case 3:
                // Implement view plan requests
                break;
            case 4:
                // Implement create quotation
                break;
            case 5:
                // Back to Main Menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void userActions(UserService userService, VendorService vendorService) {
        // Implement user actions here
        System.out.println("User Actions:");
        System.out.println("1. Insert Plan Request");
        System.out.println("2. View Quotations");
        System.out.println("3. User Registration");
        System.out.println("4. Update Quotations");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
        case 1:
            // Implement insert plan request
            break;
        case 2:
            // Implement view quotations
            break;
        case 3:
            // Implement user registration
            break;
        case 4:
            // Implement update quotations
            break;
        case 5:
            // Back to Main Menu
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
}
}

