package com.demo.dao;

import com.demo.model.Quotation;

import java.util.List;

public interface QuotationDAO {
    Quotation findById(long quotationId);
    List<Quotation> findAll();
    void save(Quotation quotation);
    void update(Quotation quotation);
    void delete(long quotationId);
}
