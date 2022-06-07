package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.api;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductCatagoryService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductReviewService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/marketplace-products-review")
@CrossOrigin
public class ProductReviewController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductReviewService productReviewService;

    @PostMapping(
            path = {"/user/member /make-review"},
            params ={ "userId","productId"})
    public ResponseEntity saveProduct(
            @Valid @RequestBody RequestProductReviewDTO dto,
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "productId") String productId) {
        String id = productReviewService.saveProductReview(dto, userId,productId);
        return new ResponseEntity(new StandardResponse(201, id + " property successfully saved!", true),
                HttpStatus.CREATED);
    }

    }

