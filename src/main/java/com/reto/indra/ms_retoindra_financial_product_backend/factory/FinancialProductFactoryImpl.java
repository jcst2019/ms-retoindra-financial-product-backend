package com.reto.indra.ms_retoindra_financial_product_backend.factory;

import com.org.reto.indra.enums.ProductType;
import com.reto.indra.ms_retoindra_financial_product_backend.model.*;
import org.springframework.stereotype.Component;

import static com.org.reto.indra.enums.ProductType.*;
import static com.org.reto.indra.enums.ProductType.SAVINGS_ACCOUNT;

@Component
public class FinancialProductFactoryImpl implements FinancialProductFactory {

    @Override
    public FinancialProduct createProduct(Integer type, String uniqueCode, String coinType) {
        FinancialProduct product;
        switch (type) {
            case 1:
                product = new SavingsAccount();
                break;
            case 2:
                product = new CreditCard();
                break;
            case 3:
                product = new CheckingAccount();
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
        product.setUniqueCode(uniqueCode);
        product.setCoinType(coinType);
        return product;
    }
}