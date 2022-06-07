package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.api;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestHotDealAdvertisementDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.HotDealAdvertisementService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductReviewService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/marketplace-hot-deal-advertisement")
@CrossOrigin
public class HotDealAdvertisementController {
    private final Logger LOGGER = LoggerFactory.getLogger(HotDealAdvertisementController.class);

    @Autowired
    private HotDealAdvertisementService hotDealAdvertisementService;

    @PostMapping(
            path = {"/admin/member/business/make-package"},
            params ={ "prefix","productId"})
    public ResponseEntity saveProduct(
            @Valid @RequestBody RequestHotDealAdvertisementDTO dto,
            @RequestParam(value = "prefix") String prefix,
            @RequestParam(value = "productId") String productId) {
        String id = hotDealAdvertisementService.saveHotDealAdvertisement(dto, prefix,productId);
        return new ResponseEntity(new StandardResponse(201, id + " property successfully saved!", true),
                HttpStatus.CREATED);
    }
}
