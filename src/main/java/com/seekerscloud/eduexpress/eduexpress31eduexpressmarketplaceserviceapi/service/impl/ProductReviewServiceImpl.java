package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductReview;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.NotFoundException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.ValidateException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductCatagoryRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductReviewRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductReviewService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.Generator;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductCatagoryMapper;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductReviewMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {
    @Autowired
    private ProductReviewRepo productReviewRepo;

    @Autowired
    private Generator generator;
    @Autowired
    private ProductRepo productRepo;


    @Autowired
    private ProductReviewMapper productReviewMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveProductReview(RequestProductReviewDTO dto, String userId,String productId) {
        String propertyId = generator.createProductId(userId);
        Product product = productRepo.getById(productId);
        System.out.println("wwwww "+product.getProductId());
        ProductReviewDTO productReviewDTO = new ProductReviewDTO(
                propertyId,
                userId,
                dto.getStar(),
                dto.getComments(),
                dto.getReviewDate(),
                dto.getAvatar(),
                dto.getUserName(),
               modelMapper.map(productRepo.getById(productId),ProductDTO.class));

        if (!productReviewRepo.existsById(productReviewDTO.getPropertyId())) {
            return productReviewRepo.save(productReviewMapper.toProductReview(productReviewDTO)).getPropertyId() ;
        } else {
            throw new NotFoundException("Already Exists");
        }

    }

}

