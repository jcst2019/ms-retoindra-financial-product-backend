package com.reto.indra.ms_retoindra_financial_product_backend.controller;

import com.org.reto.indra.util.EncryptionAESUtil;
import com.reto.indra.ms_retoindra_financial_product_backend.dto.FinancialProductDTO;
import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProductDocument;
import com.reto.indra.ms_retoindra_financial_product_backend.service.FinancialProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/financialProducts")
public class FinancialProductController {

    private static final Logger logger = LoggerFactory.getLogger(FinancialProductController.class);
    @Autowired
    FinancialProductService financialProductService;

    @GetMapping(value="/")
    public ResponseEntity<Flux<FinancialProduct>> listFinancialProduct(){
        return new ResponseEntity<>(financialProductService.listFinancialProduct(), HttpStatus.OK);
    }

    @GetMapping(value="/findByUniqueCode")
    public ResponseEntity<Flux<FinancialProduct>> findByUniqueCode(@RequestParam("uniqueCode") String encodedUniqueCode){
        encodedUniqueCode = encodedUniqueCode.replace(" ", "+");
        logger.info("encodedUniqueCode: {}", encodedUniqueCode);
        return new ResponseEntity<>(financialProductService.listFinancialProductByUniqueCode(encodedUniqueCode), HttpStatus.OK);
    }

    @PostMapping(value="/create")
    public ResponseEntity<Mono<FinancialProduct>> createFinancialProduct(@RequestBody FinancialProduct financialProduct) {
        try {
            logger.info("customer =>: {}", financialProduct.toString());
            financialProduct.setTypeAndName();
            logger.info("customer =>: {}", financialProduct.toString());
            return new ResponseEntity<>(financialProductService.createFinancialProduct(financialProduct), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error createFinancialProduct", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
