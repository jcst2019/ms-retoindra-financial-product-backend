package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.org.reto.indra.enums.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingsAccount extends FinancialProduct {
    private double interestRate;

    public SavingsAccount() {
        NodeProducts node = new NodeProducts();
        node.setType(ProductType.SAVINGS_ACCOUNT.getType()); // Assuming 1 represents SAVINGS_ACCOUNT
        node.setName(ProductType.SAVINGS_ACCOUNT.getName());
        this.setNodeProducts(List.of(node));
    }
}