package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.entities.Product;
import com.felipeleres.flcommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.ReadOnlyBufferException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findByID (Long id){
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;
    }

}
