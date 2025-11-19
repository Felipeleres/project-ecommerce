package com.felipeleres.flcommerce.controllers;


import com.felipeleres.flcommerce.dto.OrderDTO;
import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.dto.ProductMinDTO;
import com.felipeleres.flcommerce.services.OrderService;
import com.felipeleres.flcommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value= "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById (@PathVariable Long id) {
        OrderDTO orderDTO = orderService.findByID(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insert (@Valid @RequestBody OrderDTO orderDTO){
        orderDTO =  orderService.insert(orderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(orderDTO);
    }


}
