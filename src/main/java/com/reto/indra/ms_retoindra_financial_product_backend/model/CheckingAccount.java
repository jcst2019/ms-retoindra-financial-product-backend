package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.org.reto.indra.enums.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CheckingAccount extends FinancialProduct {
    private double overdraftLimit;

    public CheckingAccount() {
        this.setTypeAndName();
    }

    @Override
    public void setTypeAndName() {
        this.setType(ProductType.CHECKING_ACCOUNT.getType());
        this.setName(ProductType.CHECKING_ACCOUNT.getName());
    }

    @Override
    public String toString() {
        return super.toString() + " CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                '}';
    }

}
