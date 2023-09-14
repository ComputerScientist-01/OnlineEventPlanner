package com.demo.service;

import com.demo.dao.PlanRequestDAO;
import com.demo.model.PlanRequest;

import java.util.List;

public class PlanRequestServiceImpl implements PlanRequestService {

    private PlanRequestDAO planRequestDAO;

    public PlanRequestServiceImpl(PlanRequestDAO planRequestDAO) {
        this.planRequestDAO = planRequestDAO;
    }

    @Override
    public PlanRequest findById(long requestId) {
        return planRequestDAO.findById(requestId);
    }

    @Override
    public List<PlanRequest> findAll() {
        return planRequestDAO.findAll();
    }

    @Override
    public void save(PlanRequest planRequest) {
        planRequestDAO.save(planRequest);
    }

    @Override
    public void update(PlanRequest planRequest) {
        planRequestDAO.update(planRequest);
    }

    @Override
    public void delete(long requestId) {
        planRequestDAO.delete(requestId);
    }
}
