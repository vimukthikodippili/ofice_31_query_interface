package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductReview;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductReviewMapper {
    ProductReview toProductReview(ProductReviewDTO productReviewDTO);
    ProductReviewDTO toProductReviewDTO(ProductReview productReview);
    List<ProductReviewDTO> pageToProductReviewDTO(Page<ProductReview> productReviews);
    List<ProductReview> toProductReview(List<ProductReviewDTO> productReviewDTOS);
}
