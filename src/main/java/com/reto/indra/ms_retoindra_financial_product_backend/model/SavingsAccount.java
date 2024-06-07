package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.org.reto.indra.enums.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingsAccount extends FinancialProduct {
    private double interestRate;

    public SavingsAccount() {
        this.setTypeAndName();
    }

    @Override
    public void setTypeAndName() {
        this.setType(ProductType.SAVINGS_ACCOUNT.getType());
        this.setName(ProductType.SAVINGS_ACCOUNT.getName());
    }

    @Override
    public String toString() {
        return super.toString() + " SavingsAccount{" +
                    "interestRate=" + interestRate +
                '}';
    }
}