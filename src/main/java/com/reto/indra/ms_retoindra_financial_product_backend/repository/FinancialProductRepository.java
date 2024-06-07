package com.reto.indra.ms_retoindra_financial_product_backend.repository;

import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FinancialProductRepository extends ReactiveMongoRepository<FinancialProduct, String> {
    Mono<FinancialProduct> findByUniqueCode(String uniqueCode);
}
