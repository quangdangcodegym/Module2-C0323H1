package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product findProductById(long idProduct);
    void updateProductById(long idProduct, Product product);
    void deleteProductById(long idProduct);
    void addProduct(Product product);
}
