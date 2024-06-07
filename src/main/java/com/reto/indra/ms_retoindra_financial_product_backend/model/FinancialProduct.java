package com.reto.indra.ms_retoindra_financial_product_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "products")
public class FinancialProduct {

    @Id
    private String id;
    private String uniqueCode;
    private List<NodeProducts> nodeProducts;
    private String coinType;

}
