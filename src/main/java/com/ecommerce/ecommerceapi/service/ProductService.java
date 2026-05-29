package com.ecommerce.ecommerceapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapi.model.Product;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(1L, "Laptop", 50000, 10));
        productList.add(new Product(2L, "Mouse", 500, 50));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);

        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
        }

        return product;
    }

    public boolean deleteProduct(Long id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }
}