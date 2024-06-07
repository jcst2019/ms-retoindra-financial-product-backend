package com.reto.indra.ms_retoindra_financial_product_backend.mapper;

import com.reto.indra.ms_retoindra_financial_product_backend.dto.FinancialProductDTO;
import com.reto.indra.ms_retoindra_financial_product_backend.model.CheckingAccount;
import com.reto.indra.ms_retoindra_financial_product_backend.model.CreditCard;
import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import com.reto.indra.ms_retoindra_financial_product_backend.model.SavingsAccount;

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
}
