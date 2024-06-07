package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.org.reto.indra.enums.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CheckingAccount extends FinancialProduct {
    private double overdraftLimit;

    public CheckingAccount() {
        this.setType(ProductType.CHECKING_ACCOUNT.getType());
        this.setName(ProductType.CHECKING_ACCOUNT.getName());
    }
}
