package com.demo.dao;

import com.demo.model.Package;
import com.demo.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAOImpl implements PackageDAO {

    private Connection connection;

    public PackageDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public Package findById(long packageId) {
        Package aPackage = null;
        String query = "SELECT * FROM packages WHERE package_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, packageId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                aPackage = mapResultSetToPackage(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aPackage;
    }

    @Override
    public List<Package> findAll() {
        List<Package> packages = new ArrayList<>();
        String query = "SELECT * FROM packages";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                packages.add(mapResultSetToPackage(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }

    @Override
    public void save(Package aPackage) {
        String query = "INSERT INTO packages (type, package_type, services, amount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, aPackage.getType());
            preparedStatement.setString(2, aPackage.getPackageType());
            preparedStatement.setString(3, String.join(",", aPackage.getServices()));
            preparedStatement.setDouble(4, aPackage.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Package aPackage) {
        String query = "UPDATE packages SET type=?, package_type=?, services=?, amount=? WHERE package_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, aPackage.getType());
            preparedStatement.setString(2, aPackage.getPackageType());
            preparedStatement.setString(3, String.join(",", aPackage.getServices()));
            preparedStatement.setDouble(4, aPackage.getAmount());
            preparedStatement.setLong(5, aPackage.getPackageId()); // Set the package_id for the WHERE clause
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long packageId) {
        String query = "DELETE FROM packages WHERE package_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, packageId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Package mapResultSetToPackage(ResultSet resultSet) throws SQLException {
        Package aPackage = new Package();
        aPackage.setPackageId(resultSet.getLong("package_id"));
        aPackage.setType(resultSet.getString("type"));
        aPackage.setPackageType(resultSet.getString("package_type"));
        String[] services = resultSet.getString("services").split(",");
        aPackage.setServices(List.of(services));
        aPackage.setAmount(resultSet.getDouble("amount"));
        return aPackage;
    }
}
