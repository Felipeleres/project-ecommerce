package com.felipeleres.flcommerce.controllers;


import com.felipeleres.flcommerce.dto.ProductDTO;

import com.felipeleres.flcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById (@PathVariable Long id) {
        ProductDTO productDTO = productService.findByID(id);
        return productDTO;
    }

    @GetMapping
    public Page<ProductDTO> findAll (Pageable pageable) {
        return productService.findAll(pageable);
    }

}
