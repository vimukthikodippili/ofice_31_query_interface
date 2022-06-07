package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.api;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductCatagoryService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/marketplace-products-catagory")
@CrossOrigin
public class ProductCatagoryController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductCatagoryController.class);

    @Autowired
    private ProductCatagoryService productCatagoryService;
    @PostMapping(
            path = "/host/member/business/make-producte-category"
    )
    public ResponseEntity saveProduct(@RequestBody RequestProductCatagoryDTO dto, @RequestParam(value = "departmentid") String departmentid ) {
        String id = productCatagoryService.saveProductCatagory(dto,departmentid);
        return new ResponseEntity(new StandardResponse(201, id + " provider successfully saved!", true),
                HttpStatus.CREATED);
    }
}
