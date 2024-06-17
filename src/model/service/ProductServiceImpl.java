package model.service;

import exception.CustomExceptionHandling;
import mapper.ProductMapper;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<ProductDto> queryAllProducts() throws CustomExceptionHandling {
        try {
            List<Product> products = productDao.queryAllProducts();
            if (!(products.isEmpty())) {
                return productDao.queryAllProducts().stream().map(ProductMapper::mapProductToProductDto).toList();
            }else {
                throw new CustomExceptionHandling("No Data !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewProduct(Product product) throws CustomExceptionHandling {
        try {
            if (productDao.addNewProduct(product) > 0) {
                throw new CustomExceptionHandling("Product Added Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant add product !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProductById(Integer id) throws CustomExceptionHandling {
        try{
            if (productDao.updateProduct(id)>0){
                throw new CustomExceptionHandling("Product Updated Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant update product !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        try{
            if (productDao.deleteProduct(id)>0){
                throw new CustomExceptionHandling("Product Deleted Successfully !");
            }else {
                throw new CustomExceptionHandling("Cant delete product !");
            }
        }catch (CustomExceptionHandling e){
            System.out.println(e.getMessage());
        }
    }
}
