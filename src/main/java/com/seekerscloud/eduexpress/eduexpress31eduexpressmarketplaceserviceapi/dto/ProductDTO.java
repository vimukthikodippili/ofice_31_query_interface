package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements SuperDTO {
    private String productId;
    private ArrayList availableCountries;
    private boolean worldWideState;
    private ArrayList thumbNail;
    private String productName;
    private String productTitle;
    private Double cost;
    private String providerId;
    private String providerType;
    private Date postedDate;
    private boolean activeState;
    private ArrayList otherData;
    private boolean payedState;
    private boolean stockAvailability;
    private String stateType;
    private boolean verifyState;
    private ProductCatagoryDTO productCategories;

}
