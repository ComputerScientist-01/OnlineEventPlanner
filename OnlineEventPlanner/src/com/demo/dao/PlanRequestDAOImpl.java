package com.demo.dao;

import com.demo.model.PlanRequest;
import com.demo.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanRequestDAOImpl implements PlanRequestDAO {

    private Connection connection;

    public PlanRequestDAOImpl() {
        // Initialize the database connection here (e.g., using DatabaseConnection class)
        connection = DBUtil.getConnection();
    }

    @Override
    public PlanRequest findById(long requestId) {
        PlanRequest planRequest = null;
        String query = "SELECT * FROM plan_requests WHERE request_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, requestId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                planRequest = mapResultSetToPlanRequest(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planRequest;
    }

    @Override
    public List<PlanRequest> findAll() {
        List<PlanRequest> planRequests = new ArrayList<>();
        String query = "SELECT * FROM plan_requests";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                planRequests.add(mapResultSetToPlanRequest(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planRequests;
    }

    @Override
    public void save(PlanRequest planRequest) {
        String query = "INSERT INTO plan_requests (from_date, to_date, services_needed, " +
                "persons_attending, other_services) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, planRequest.getFromDate());
            preparedStatement.setDate(2, planRequest.getToDate());
            // Set other parameters accordingly
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PlanRequest planRequest) {
        String query = "UPDATE plan_requests SET from_date=?, to_date=?, services_needed=?, " +
                "persons_attending=?, other_services=? WHERE request_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, planRequest.getFromDate());
            preparedStatement.setDate(2, planRequest.getToDate());
            // Set other parameters accordingly
            preparedStatement.setLong(6, planRequest.getRequestId()); // Set the request_id for the WHERE clause
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long requestId) {
        String query = "DELETE FROM plan_requests WHERE request_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, requestId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private PlanRequest mapResultSetToPlanRequest(ResultSet resultSet) throws SQLException {
        // Map ResultSet data to a PlanRequest object
        PlanRequest planRequest = new PlanRequest();
        planRequest.setRequestId(resultSet.getLong("request_id"));
        planRequest.setFromDate(resultSet.getDate("from_date"));
        planRequest.setToDate(resultSet.getDate("to_date"));
        // Map other attributes accordingly
        return planRequest;
    }
}
