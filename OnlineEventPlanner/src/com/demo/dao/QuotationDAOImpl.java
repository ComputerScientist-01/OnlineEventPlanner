package com.demo.dao;

import com.demo.model.Quotation;
import com.demo.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuotationDAOImpl implements QuotationDAO {

    private Connection connection;

    public QuotationDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public Quotation findById(long quotationId) {
        Quotation quotation = null;
        String query = "SELECT * FROM quotations WHERE quotation_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, quotationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                quotation = mapResultSetToQuotation(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quotation;
    }

    @Override
    public List<Quotation> findAll() {
        List<Quotation> quotations = new ArrayList<>();
        String query = "SELECT * FROM quotations";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                quotations.add(mapResultSetToQuotation(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quotations;
    }

    @Override
    public void save(Quotation quotation) {
        String query = "INSERT INTO quotations (package_type, estimated_amount, user_id, vendor_id, status) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, quotation.getPackageType());
            preparedStatement.setDouble(2, quotation.getEstimatedAmount());
            preparedStatement.setLong(3, quotation.getUserId());
            preparedStatement.setLong(4, quotation.getVendorId());
            preparedStatement.setString(5, quotation.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Quotation quotation) {
        String query = "UPDATE quotations SET package_type=?, estimated_amount=?, user_id=?, vendor_id=?, status=? " +
                "WHERE quotation_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, quotation.getPackageType());
            preparedStatement.setDouble(2, quotation.getEstimatedAmount());
            preparedStatement.setLong(3, quotation.getUserId());
            preparedStatement.setLong(4, quotation.getVendorId());
            preparedStatement.setString(5, quotation.getStatus());
            preparedStatement.setLong(6, quotation.getQuotationId()); // Set the quotation_id for the WHERE clause
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long quotationId) {
        String query = "DELETE FROM quotations WHERE quotation_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, quotationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Quotation mapResultSetToQuotation(ResultSet resultSet) throws SQLException {
        Quotation quotation = new Quotation();
        quotation.setQuotationId(resultSet.getLong("quotation_id"));
        quotation.setPackageType(resultSet.getString("package_type"));
        quotation.setEstimatedAmount(resultSet.getDouble("estimated_amount"));
        quotation.setUserId(resultSet.getLong("user_id"));
        quotation.setVendorId(resultSet.getLong("vendor_id"));
        quotation.setStatus(resultSet.getString("status"));
        return quotation;
    }
}
