package model.service;

import exception.CustomExceptionHandling;
import mapper.OrderMapper;
import model.dao.OrderDao;
import model.dao.OrderDaoImpl;
import model.dto.OrderDto;
import model.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<OrderDto> queryAllOrders(){
        try {
            List<Order> orders = orderDao.queryAllOrders();
            if(!(orders.isEmpty())){
                return orderDao.queryAllOrders().stream().map(OrderMapper::mapOrderToOrderDto).toList();
            }else {
                throw new CustomExceptionHandling("No Data !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewOrder(Order order){
        try{
            if (orderDao.addNewOrder(order) > 0) {
                throw new CustomExceptionHandling("Order Added Successfully !");
            }else{
                throw new CustomExceptionHandling("Cant add order");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateOrderById(Integer id) {
        try {
            if(orderDao.updateOrder(id)>0) {
                throw new CustomExceptionHandling("Order Updated Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant update order");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteOrderById(Integer id) {
        try {
            if(orderDao.deleteOrderById(id)>0) {
                throw new CustomExceptionHandling("Order Deleted Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant delete order");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }
}
