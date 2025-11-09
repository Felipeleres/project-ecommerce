package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.entities.Product;
import com.felipeleres.flcommerce.repositories.ProductRepository;

import com.felipeleres.flcommerce.services.exceptions.DataBaseException;
import com.felipeleres.flcommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findByID (Long id){
        Optional<Product> result = productRepository.findById(id);
        Product product = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll (String name,Pageable pageable){
        Page<Product> result = productRepository.searchByName(name,pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert (ProductDTO productDTO){

        Product product = new Product();
        copyDtoToEntity(productDTO,product);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update (Long id,ProductDTO productDTO){

        try {
            Product product = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);
            product = productRepository.save(product);
            return new ProductDTO(product);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id){
        if(!productRepository.existsById(id)){

            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

        try {
            productRepository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DataBaseException("Falha da integridade referencial!");
        }


    }

    private void copyDtoToEntity(ProductDTO productDTO, Product product){

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }




}
