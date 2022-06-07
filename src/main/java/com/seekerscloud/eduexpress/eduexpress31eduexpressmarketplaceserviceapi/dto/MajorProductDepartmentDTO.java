package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto;

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
public class MajorProductDepartmentDTO {

    private String propertyId;
    private String typeName;
    private ArrayList otherData;
    private boolean activeState;
    private String icon;
}
