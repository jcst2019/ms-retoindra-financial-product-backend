package com.reto.indra.ms_retoindra_financial_product_backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditCard extends FinancialProduct {
    private double creditLimit;

    public CreditCard() {
        NodeProducts node = new NodeProducts();
        node.setType(2); // Assuming 2 represents CREDIT_CARD
        node.setName("Credit Card");
        this.setNodeProducts(List.of(node));
    }
}