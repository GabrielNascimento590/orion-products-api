package com.example.Orion.dto.mapper;

import com.example.Orion.dto.ProductDto;
import com.example.Orion.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto dto) {
        Product product= new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

}
