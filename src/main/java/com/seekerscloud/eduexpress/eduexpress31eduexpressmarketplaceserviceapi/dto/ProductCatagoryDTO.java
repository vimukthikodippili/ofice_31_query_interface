package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.MajorProductDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatagoryDTO implements  SuperDTO{

    private String ProductCatagoryId;
    private String catagory;
    private boolean activeState;
    private ArrayList otherData;
    private ArrayList thumbNail;
    private MajorProductDepartmentDTO majorProductDepartment;

}
