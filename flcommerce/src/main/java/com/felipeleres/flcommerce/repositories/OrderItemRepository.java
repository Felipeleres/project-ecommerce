package com.felipeleres.flcommerce.repositories;

import com.felipeleres.flcommerce.entities.Order;
import com.felipeleres.flcommerce.entities.OrderItem;
import com.felipeleres.flcommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, OrderItemPK> {


}
