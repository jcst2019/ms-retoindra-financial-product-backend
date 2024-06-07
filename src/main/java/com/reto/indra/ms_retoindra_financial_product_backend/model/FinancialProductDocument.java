package com.reto.indra.ms_retoindra_financial_product_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class FinancialProductDocument {
    @Id
    private String id;
    private String uniqueCode;
    private String coinType;
    private int type;
    private String name;
    private Double interestRate; // Solo para SavingsAccount
    private Double creditLimit;  // Solo para CreditCard
    private Double overdraftLimit; // Solo para CheckingAccount
}
