package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.dto.OrderDTO;
import com.felipeleres.flcommerce.dto.OrderItemDTO;
import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.entities.Order;
import com.felipeleres.flcommerce.entities.OrderItem;
import com.felipeleres.flcommerce.entities.Product;
import com.felipeleres.flcommerce.entities.User;
import com.felipeleres.flcommerce.enums.OrderStatus;
import com.felipeleres.flcommerce.repositories.OrderItemRepository;
import com.felipeleres.flcommerce.repositories.OrderRepository;
import com.felipeleres.flcommerce.repositories.ProductRepository;
import com.felipeleres.flcommerce.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public OrderDTO findByID (Long id){
        Optional<Order> result = orderRepository.findById(id);
        Order order = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        OrderDTO orderDTO = new OrderDTO(order);
        return orderDTO;
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {

        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO: orderDTO.getItems() ){
            Product product =  productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem orderItem =  new OrderItem(product,order,itemDTO.getQuantity(),product.getPrice());
            order.getItems().add(orderItem);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
