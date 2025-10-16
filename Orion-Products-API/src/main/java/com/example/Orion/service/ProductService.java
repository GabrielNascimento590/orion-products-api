package com.example.Orion.service;

import com.example.Orion.dto.ProductDto;
import com.example.Orion.dto.mapper.ProductMapper;
import com.example.Orion.model.Product;
import com.example.Orion.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // Injeção de dependências via construtor
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // 🔹 Retorna todos os produtos (Entity → DTO)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    // 🔹 Busca um produto por ID (Entity → DTO)
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
        return productMapper.toDto(product);
    }

    // 🔹 Cria um novo produto (DTO → Entity)
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    // 🔹 Atualiza um produto existente (DTO → Entity → DTO)
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found "));

        // Copia os dados do DTO para a entidade existente
        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setStock(productDto.getStock());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    // 🔹 Deleta um produto
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product Not Found");
        }
        productRepository.deleteById(id);
    }
}


