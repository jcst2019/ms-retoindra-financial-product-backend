package com.reto.indra.ms_retoindra_financial_product_backend.factory;

import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;

public interface FinancialProductFactory {
    FinancialProduct createProduct(Integer type, String uniqueCode, String coinType);
}
