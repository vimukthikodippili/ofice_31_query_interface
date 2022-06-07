package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMajorProductDepartmentDTO {
   // private String propertyId;
    private String typeName;
    private ArrayList otherData;
   // private boolean activeState;
    private String icon;

}
