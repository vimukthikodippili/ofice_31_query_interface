package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.MajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.GeneratedIdentificationDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.EntryDuplicateException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.ValidateException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.MajorProductDepartmentRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductCatagoryRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductCatagoryService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.Generator;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductCatagoryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

//package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;
//
//import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
//import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductCatagoryRepo;
//import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
//import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
//import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
@Service
public class ProductCatagoryServiceImpl implements ProductCatagoryService {

    @Autowired
    private Generator generator;

    @Autowired
    private ProductCatagoryRepo productCatagoryRepo;

    @Autowired
    private MajorProductDepartmentRepo majorProductDepartmentRepo;

    @Autowired
    private ProductCatagoryMapper productCatagoryMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveProductCatagory(RequestProductCatagoryDTO dto, String departmentId) {
        GeneratedIdentificationDTO generatedIdentificationData = generator.createId();

        ProductCatagoryDTO productCatagoryDTO = new ProductCatagoryDTO(
                generatedIdentificationData.getPrefix() + "-" + generatedIdentificationData.getId(),
                dto.getCatagory(),
                true,
                new ArrayList(),
                dto.getThumbNail(),
                modelMapper.map(majorProductDepartmentRepo.getById(departmentId),MajorProductDepartmentDTO.class)
        );







        if (!productCatagoryRepo.existsById(productCatagoryDTO.getProductCatagoryId())) {
            return productCatagoryRepo.save(productCatagoryMapper.toProductCatagory(productCatagoryDTO)).getProductCatagoryId();
        } else {
            throw new EntryDuplicateException("already exists");
        }
    }


}


