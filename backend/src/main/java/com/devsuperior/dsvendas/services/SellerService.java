package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dtos.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Collection<SellerDTO> findAll() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}
