package model.service;

import exception.CustomExceptionHandling;
import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> queryAllProducts() throws CustomExceptionHandling;
    void addNewProduct(Product product) throws CustomExceptionHandling;
    void updateProductById(Integer id) throws CustomExceptionHandling;
    void deleteProductById(Integer id);
}
