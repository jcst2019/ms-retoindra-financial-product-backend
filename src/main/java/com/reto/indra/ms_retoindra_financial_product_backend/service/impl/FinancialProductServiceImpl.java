package com.reto.indra.ms_retoindra_financial_product_backend.service.impl;

import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import com.reto.indra.ms_retoindra_financial_product_backend.repository.FinancialProductRepository;
import com.reto.indra.ms_retoindra_financial_product_backend.service.FinancialProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FinancialProductServiceImpl implements FinancialProductService {

    @Autowired
    FinancialProductRepository financialProductRepository;

    @Override
    public Flux<FinancialProduct> listFinancialProduct() {
        return financialProductRepository.findAll();
    }

    @Override
    public Mono<FinancialProduct> createFinancialProduct(FinancialProduct financialProduct) {
        return financialProductRepository.save(financialProduct);
    }
}
