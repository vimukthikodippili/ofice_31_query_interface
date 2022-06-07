package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCatagoryMapper {
    ProductCatagory toProductCatagory(ProductCatagoryDTO productCatagoryDTO);
    ProductCatagoryDTO toProductCatagoryDTO(ProductCatagory productCatagory);
    List<ProductCatagoryDTO> pageToProductCatagoryDTO(Page<ProductCatagory> productCatagories);
    List<ProductCatagory> toProductCatagory(List<ProductCatagoryDTO> productCatagoryDTOS);
}
