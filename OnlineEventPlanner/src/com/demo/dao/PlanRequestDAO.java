package com.demo.dao;

import com.demo.model.PlanRequest;

import java.util.List;

public interface PlanRequestDAO {
    PlanRequest findById(long requestId);
    List<PlanRequest> findAll();
    void save(PlanRequest planRequest);
    void update(PlanRequest planRequest);
    void delete(long requestId);
}
