package com.example.Orion.service;

import com.example.Orion.model.Product;
import com.example.Orion.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductAll() {
        return productRepository.findAll();
    }

    public Product getAllByid(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Product CreateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product productdetails) {
        Product product = getAllByid(id);
        product.setId(productdetails.getId());
        product.setName(productdetails.getName());
        product.setStock(productdetails.getStock());
        product.setPrice(productdetails.getPrice());
        product.setDescription(productdetails.getDescription());
        return productRepository.save(product);
    }
    public void delete(Long id) {
        Product product=getAllByid(id);
        productRepository.delete(product);
    }



}
