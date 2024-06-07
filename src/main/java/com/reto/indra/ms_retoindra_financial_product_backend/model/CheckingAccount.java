package com.reto.indra.ms_retoindra_financial_product_backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CheckingAccount extends FinancialProduct {
    private double overdraftLimit;

    public CheckingAccount() {
        NodeProducts node = new NodeProducts();
        node.setType(4); // Assuming 4 represents CHECKING_ACCOUNT
        node.setName("Checking Account");
        this.setNodeProducts(List.of(node));
    }
}
