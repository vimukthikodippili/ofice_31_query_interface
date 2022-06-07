package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestMajorProductDepartmentDTO;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestMajorProductDepartmentUpdateDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnMajorProductDepartmentDTO;

import java.util.List;

public interface MajorProductDepartmentService {
    public String saveMajorProductDepartment(RequestMajorProductDepartmentDTO dto);
    boolean deleteMajorProductDepartment(String id);
    List<ReturnMajorProductDepartmentDTO> getMajorProductDepartment();
    //public String updateMajorProductDepartment(String propertyId, RequestMajorProductDepartmentUpdateDTO dto);
}
