package com.reto.indra.ms_retoindra_financial_product_backend.service;

import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FinancialProductService {
    Flux<FinancialProduct> listFinancialProduct();
    Mono<FinancialProduct> createFinancialProduct(FinancialProduct financialProduct);

}
