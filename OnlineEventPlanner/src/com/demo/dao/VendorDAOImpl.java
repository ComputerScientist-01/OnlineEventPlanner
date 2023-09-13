package com.demo.dao;

import com.demo.model.Vendor;
import com.demo.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAOImpl implements VendorDAO {

    private Connection connection;

    public VendorDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public Vendor findById(long vendorId) {
        Vendor vendor = null;
        String query = "SELECT * FROM vendors WHERE vendor_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, vendorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                vendor = mapResultSetToVendor(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendor;
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> vendors = new ArrayList<>();
        String query = "SELECT * FROM vendors";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vendors.add(mapResultSetToVendor(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    @Override
    public void save(Vendor vendor) {
        String query = "INSERT INTO vendors (name, address, email, contact_numbers, event_packages) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vendor.getName());
            preparedStatement.setString(2, vendor.getAddress());
            preparedStatement.setString(3, vendor.getEmail());
            preparedStatement.setString(4, String.join(",", vendor.getContactNumbers()));
            preparedStatement.setString(5, vendor.getEventPackages());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vendor vendor) {
        String query = "UPDATE vendors SET name=?, address=?, email=?, contact_numbers=?, event_packages=? " +
                "WHERE vendor_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vendor.getName());
            preparedStatement.setString(2, vendor.getAddress());
            preparedStatement.setString(3, vendor.getEmail());
            preparedStatement.setString(4, String.join(",", vendor.getContactNumbers()));
            preparedStatement.setString(5, vendor.getEventPackages());
            preparedStatement.setLong(6, vendor.getVendorId()); // Set the vendor_id for the WHERE clause
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long vendorId) {
        String query = "DELETE FROM vendors WHERE vendor_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, vendorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Vendor mapResultSetToVendor(ResultSet resultSet) throws SQLException {
        Vendor vendor = new Vendor();
        vendor.setVendorId(resultSet.getLong("vendor_id"));
        vendor.setName(resultSet.getString("name"));
        vendor.setAddress(resultSet.getString("address"));
        vendor.setEmail(resultSet.getString("email"));
        String[] contactNumbers = resultSet.getString("contact_numbers").split(",");
        vendor.setContactNumbers(List.of(contactNumbers));
        vendor.setEventPackages(resultSet.getString("event_packages"));
        return vendor;
    }
}
