package model.service;

import exception.CustomExceptionHandling;
import mapper.CustomerMapper;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImpl;
import model.dto.CustomerDto;
import model.entity.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public List<CustomerDto> queryAllCustomers() {
        try {
            List<Customer> customers = customerDao.queryAllCustomers();
            if(!(customers.isEmpty())){
                return customerDao.queryAllCustomers().stream().map(CustomerMapper::mapCustomerToCustomerDto).toList();
            }else {
                throw new CustomExceptionHandling("No Data !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewCustomer(Customer customer){
        try{
            if (customerDao.addNewCustomer(customer) > 0) {
                throw new CustomExceptionHandling("Customer Added Successfully !");
            }else{
                throw new CustomExceptionHandling("Cant add customer");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCustomerById(Integer id){
        try {
            if (customerDao.updateCustomerById(id) > 0) {
                throw new CustomExceptionHandling("Customer Updated Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant update customer");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        try {
            if (customerDao.deleteCustomerById(id) > 0) {
                throw new CustomExceptionHandling("Customer Deleted Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant delete customer");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }


}
