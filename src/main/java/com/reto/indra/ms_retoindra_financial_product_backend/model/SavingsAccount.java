package com.reto.indra.ms_retoindra_financial_product_backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingsAccount extends FinancialProduct {
    private double interestRate;

    public SavingsAccount() {
        NodeProducts node = new NodeProducts();
        node.setType(1); // Assuming 1 represents SAVINGS_ACCOUNT
        node.setName("Savings Account");
        this.setNodeProducts(List.of(node));
    }
}