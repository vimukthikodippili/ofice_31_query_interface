package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;

public interface ProductReviewService {
    public String saveProductReview(RequestProductReviewDTO dto, String userId,String productId);



}
