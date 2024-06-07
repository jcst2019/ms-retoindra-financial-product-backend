package com.reto.indra.ms_retoindra_financial_product_backend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SavingsAccount.class, name = "1"),
        @JsonSubTypes.Type(value = CreditCard.class, name = "2"),
        @JsonSubTypes.Type(value = CheckingAccount.class, name = "3")
})
public abstract class FinancialProduct {

    @Id
    private String id;
    private String uniqueCode;
    private String coinType;
    private int type;
    private String name;

    public abstract void setTypeAndName();

    @Override
    public String toString() {
        return "FinancialProduct{" +
                "id='" + id + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", coinType='" + coinType + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
