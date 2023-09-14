package com.demo.service;

import com.demo.dao.QuotationDAO;
import com.demo.model.Quotation;

import java.util.List;

public class QuotationServiceImpl implements QuotationService {

    private QuotationDAO quotationDAO;

    public QuotationServiceImpl(QuotationDAO quotationDAO) {
        this.quotationDAO = quotationDAO;
    }

    @Override
    public Quotation findById(long quotationId) {
        return quotationDAO.findById(quotationId);
    }

    @Override
    public List<Quotation> findAll() {
        return quotationDAO.findAll();
    }

    @Override
    public void create(Quotation quotation) {
        quotationDAO.create(quotation);
    }

    @Override
    public void update(Quotation quotation) {
        quotationDAO.update(quotation);
    }

    @Override
    public void delete(long quotationId) {
        quotationDAO.delete(quotationId);
    }
}
