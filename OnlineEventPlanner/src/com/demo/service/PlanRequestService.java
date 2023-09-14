package com.demo.service;

import com.demo.model.PlanRequest;

import java.util.List;

public interface PlanRequestService {
    PlanRequest findById(long requestId);
    List<PlanRequest> findAll();
    void save(PlanRequest planRequest);
    void update(PlanRequest planRequest);
    void delete(long requestId);
}
