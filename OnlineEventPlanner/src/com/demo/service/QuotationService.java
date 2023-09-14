package com.demo.service;

import com.demo.model.Quotation;

import java.util.List;

public interface QuotationService {
    Quotation findById(long quotationId);
    List<Quotation> findAll();
    void create(Quotation quotation);
    void update(Quotation quotation);
    void delete(long quotationId);
}
