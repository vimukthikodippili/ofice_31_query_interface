package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;

public interface ProductCatagoryService {
    public String saveProductCatagory(RequestProductCatagoryDTO dto,String departmentid );
}
