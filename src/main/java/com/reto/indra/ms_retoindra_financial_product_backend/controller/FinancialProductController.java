package com.reto.indra.ms_retoindra_financial_product_backend.controller;

import com.org.reto.indra.util.EncryptionAESUtil;
import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import com.reto.indra.ms_retoindra_financial_product_backend.service.FinancialProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/financialProducts")
public class FinancialProductController {

    private static final Logger logger = LoggerFactory.getLogger(FinancialProductController.class);
    @Autowired
    FinancialProductService financialProductService;

    @GetMapping(value="/")
    public ResponseEntity<Flux<FinancialProduct>> financialProductService(){
        return new ResponseEntity<>(financialProductService.listFinancialProduct(), HttpStatus.OK);
    }
    @PostMapping(value="/create")
    public ResponseEntity<Mono<FinancialProduct>> createCustomer(@RequestBody FinancialProduct financialProduct) {
        try {
            logger.info("customer =>: {}", financialProduct.toString());
            financialProduct.setTypeAndName();
            logger.info("customer =>: {}", financialProduct.toString());
            return new ResponseEntity<>(financialProductService.createFinancialProduct(financialProduct), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
