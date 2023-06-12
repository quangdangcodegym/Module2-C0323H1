package com.codegym.service;

import com.codegym.config.Config;
import com.codegym.model.Product;
import com.codegym.utils.FileUtils;

import java.util.List;

public class ProductServiceService implements IProductService{
    private final String path = "./data/product.txt";
    @Override
    public List<Product> getAllProducts() {
        return FileUtils.readFile(path, Config.TYPE_PRODUCT);
    }

    @Override
    public Product findProductById(long idProduct) {
        List<Product> products = getAllProducts();
        for (Product p : products) {
            if (p.getId() == idProduct) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void updateProductById(long idProduct, Product product) {
        List<Product> products = getAllProducts();
        for (Product p : products) {
            if (p.getId() == idProduct) {
                p.setName(product.getName());
                p.setDeleteAt(product.getDeleteAt());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setCreateAt(product.getCreateAt());
                p.setCategory(product.getCategory());
            }
        }
        FileUtils.writeFile(path, products);
    }

    @Override
    public void deleteProductById(long idProduct) {

    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);

        FileUtils.writeFile(path, products);
    }
}
