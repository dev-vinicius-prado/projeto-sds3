package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dtos.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<Collection<SellerDTO>> getAll() {
        Collection<SellerDTO> sellerDTOS = sellerService.findAll();
        return ResponseEntity.ok(sellerDTOS);
    }
}
