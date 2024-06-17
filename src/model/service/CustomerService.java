package model.service;

import exception.CustomExceptionHandling;
import model.dto.CustomerDto;
import model.entity.Customer;

import java.util.List;

public interface CustomerService  {
    List<CustomerDto> queryAllCustomers() throws CustomExceptionHandling;
    void addNewCustomer(Customer customer) throws CustomExceptionHandling;
    void updateCustomerById(Integer id) throws CustomExceptionHandling;
    void deleteCustomerById(Integer id);
}
