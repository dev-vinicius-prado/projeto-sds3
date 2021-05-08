package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dtos.SaleDTO;
import com.devsuperior.dsvendas.dtos.SaleSuccessDTO;
import com.devsuperior.dsvendas.dtos.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> getAll(Pageable pageable) {
        Page<SaleDTO> saleDTOS = saleService.findAll(pageable);
        return ResponseEntity.ok(saleDTOS);
    }

    @GetMapping("amount-by-seller")
    public ResponseEntity<Collection<SaleSumDTO>> getAmountGroupedBySeller() {
        Collection<SaleSumDTO> saleSumDTOS = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(saleSumDTOS);
    }

    @GetMapping("success-by-seller")
    public ResponseEntity<Collection<SaleSuccessDTO>> getSuccessGroupedBySeller() {
        Collection<SaleSuccessDTO> saleSuccessDTOS = saleService.successGroupedBySeller();
        return ResponseEntity.ok(saleSuccessDTOS);
    }
}
