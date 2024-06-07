package com.reto.indra.ms_retoindra_financial_product_backend.mapper;

import com.reto.indra.ms_retoindra_financial_product_backend.dto.FinancialProductDTO;
import com.reto.indra.ms_retoindra_financial_product_backend.model.*;

public class FinancialProductMapper {

    public static FinancialProductDTO toDTO(FinancialProduct product) {
        FinancialProductDTO dto = new FinancialProductDTO();
        dto.setId(product.getId());
        dto.setUniqueCode(product.getUniqueCode());
        dto.setCoinType(product.getCoinType());
        dto.setType(product.getType());
        dto.setName(product.getName());

        if (product instanceof SavingsAccount) {
            dto.setInterestRate(((SavingsAccount) product).getInterestRate());
        } else if (product instanceof CreditCard) {
            dto.setCreditLimit(((CreditCard) product).getCreditLimit());
        } else if (product instanceof CheckingAccount) {
            dto.setOverdraftLimit(((CheckingAccount) product).getOverdraftLimit());
        }

        return dto;
    }

    public static FinancialProductDocument toDocument(FinancialProduct product) {
        FinancialProductDocument document = new FinancialProductDocument();
        document.setId(product.getId());
        document.setUniqueCode(product.getUniqueCode());
        document.setCoinType(product.getCoinType());
        document.setType(product.getType());
        document.setName(product.getName());

        if (product instanceof SavingsAccount) {
            document.setInterestRate(((SavingsAccount) product).getInterestRate());
        } else if (product instanceof CreditCard) {
            document.setCreditLimit(((CreditCard) product).getCreditLimit());
        } else if (product instanceof CheckingAccount) {
            document.setOverdraftLimit(((CheckingAccount) product).getOverdraftLimit());
        }

        return document;
    }

    public static FinancialProduct toEntity(FinancialProductDocument document) {
        FinancialProduct product;
        switch (document.getType()) {
            case 1:
                product = new SavingsAccount();
                ((SavingsAccount) product).setInterestRate(document.getInterestRate());
                break;
            case 2:
                product = new CreditCard();
                ((CreditCard) product).setCreditLimit(document.getCreditLimit());
                break;
            case 3:
                product = new CheckingAccount();
                ((CheckingAccount) product).setOverdraftLimit(document.getOverdraftLimit());
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + document.getType());
        }
        product.setId(document.getId());
        product.setUniqueCode(document.getUniqueCode());
        product.setCoinType(document.getCoinType());
        product.setType(document.getType());
        product.setName(document.getName());

        return product;
    }
}
