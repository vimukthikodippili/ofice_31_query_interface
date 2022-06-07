package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.MajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestMajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestMajorProductDepartmentUpdateDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.GeneratedIdentificationDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnMajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.MajorProductDepartment;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.EntryDuplicateException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.NotFoundException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.MajorProductDepartmentRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.MajorProductDepartmentService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.Generator;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.MajorProductDepartmentMapper;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorProductDepartmentServiceImpl implements MajorProductDepartmentService {
    @Autowired
    private Generator generator;

    @Autowired
    private MajorProductDepartmentRepo majorProductDepartmentRepo;

    @Autowired
    private MajorProductDepartmentMapper majorProductDepartmentMapper;

    @Override
    public String saveMajorProductDepartment(RequestMajorProductDepartmentDTO dto) {
        GeneratedIdentificationDTO generatedIdentificationData = generator.createId();
        MajorProductDepartmentDTO majorProductDepartmentDTO=new MajorProductDepartmentDTO(
                generatedIdentificationData.getPrefix() + "-MPD-" + generatedIdentificationData.getId(),
                dto.getTypeName(),
                dto.getOtherData(),
                true,
                dto.getIcon()


        );
        if (!majorProductDepartmentRepo.existsById(majorProductDepartmentDTO.getPropertyId())) {
            return majorProductDepartmentRepo.save(majorProductDepartmentMapper.toMajorProductDepartment(majorProductDepartmentDTO)).getPropertyId();
        } else {
            throw new EntryDuplicateException("already exists");
        }
    }

    @Override
    public boolean deleteMajorProductDepartment(String id) {
        if (!majorProductDepartmentRepo.existsById(id)) {
            throw new NotFoundException("can't find Major product department for delete..!");
        }
        majorProductDepartmentRepo.deleteById(id);
        return true;
    }

    @Override
    public List<ReturnMajorProductDepartmentDTO> getMajorProductDepartment() {
        List<ReturnMajorProductDepartmentDTO> list = new ArrayList<>();
        List<ReturnMajorProductDepartmentDTO> list1 = new ArrayList<>();
        List<MajorProductDepartment> getAll = majorProductDepartmentRepo.getPropertyByDepartment();
        for (MajorProductDepartment c : getAll) {
            list.add(
                    new ReturnMajorProductDepartmentDTO(c.getPropertyId(), c.getTypeName(), c.getOtherData(), c.getIcon()));
        }
        if (list != null) {
            return list;
        }else {
            throw new NotFoundException("no data");
        }

    }

//    @Override
//    public String updateMajorProductDepartment(String propertyId, RequestMajorProductDepartmentUpdateDTO dto) {
//        MajorProductDepartment majorProductDepartment = majorProductDepartmentRepo.getById(propertyId);
//        if (majorProductDepartmentRepo.existsById(propertyId)) {
//            majorProductDepartment.setActiveState();
//            return majorProductDepartmentRepo.save(popularProducts).getPropertyId();
//
//        } else {
//            throw new NotFoundException(" Not Found");
//        }
//    }
//
//
//    }
}
