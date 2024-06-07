package com.reto.indra.ms_retoindra_financial_product_backend.dto;

import lombok.Data;

@Data
public class FinancialProductDTO {
    private String id;
    private String uniqueCode;
    private String coinType;
    private int type;
    private String name;
    private Double interestRate; // Solo para SavingsAccount
    private Double creditLimit;  // Solo para CreditCard
    private Double overdraftLimit; // Solo para CheckingAccount
}