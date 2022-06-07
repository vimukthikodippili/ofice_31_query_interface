package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnMajorProductDepartmentDTO implements SuperDTO {
    private String propertyId;
    private String typeName;
    private ArrayList otherData;
    private String icon;

}
