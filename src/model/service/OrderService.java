package model.service;

import exception.CustomExceptionHandling;
import model.dto.OrderDto;
import model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> queryAllOrders() throws CustomExceptionHandling;
    void addNewOrder(Order order) throws CustomExceptionHandling;
    void updateOrderById(Integer id) throws CustomExceptionHandling;
    void deleteOrderById(Integer id);
}
