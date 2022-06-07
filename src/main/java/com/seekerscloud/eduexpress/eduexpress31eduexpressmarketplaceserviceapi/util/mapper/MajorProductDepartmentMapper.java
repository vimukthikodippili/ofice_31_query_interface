package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.MajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.MajorProductDepartment;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MajorProductDepartmentMapper {
    MajorProductDepartment toMajorProductDepartment(MajorProductDepartmentDTO majorProductDepartmentDTO);
    MajorProductDepartmentDTO toMajorProductDepartmentDTO( MajorProductDepartment majorProductDepartment);
    List<MajorProductDepartmentDTO> pageToMajorProductDepartmentDTO(Page<MajorProductDepartment> majorProductDepartments);
    List<MajorProductDepartment> toMajorProductDepartment(List<MajorProductDepartmentDTO> majorProductDepartmentDTOS);
}
