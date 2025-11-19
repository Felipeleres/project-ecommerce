package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.dto.OrderDTO;
import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.entities.Order;
import com.felipeleres.flcommerce.entities.Product;
import com.felipeleres.flcommerce.repositories.OrderRepository;
import com.felipeleres.flcommerce.repositories.ProductRepository;
import com.felipeleres.flcommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findByID (Long id){
        Optional<Order> result = orderRepository.findById(id);
        Order order = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        OrderDTO orderDTO = new OrderDTO(order);
        return orderDTO;
    }


}
