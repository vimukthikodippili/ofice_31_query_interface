package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> pageToProductDTO(Page<Product> products);
    List<Product> toProduct(List<ProductDTO> productDTOS);
}
