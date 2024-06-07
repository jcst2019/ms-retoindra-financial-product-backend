package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.org.reto.indra.enums.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditCard extends FinancialProduct {
    private double creditLimit;

    public CreditCard() {
        this.setTypeAndName();
    }

    @Override
    public void setTypeAndName() {
        this.setType(ProductType.CREDIT_CARD.getType());
        this.setName(ProductType.CREDIT_CARD.getName());
    }

    @Override
    public String toString() {
        return super.toString() + " CreditCard{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}