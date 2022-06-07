package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnAllStarCountProductDTO {
    private String productId;
    private ArrayList availableCountries;
    private boolean worldWideState;
    private ArrayList thumbNail;
    private String productName;
    private String productTitle;
    private String catagory;
    private Double cost;
    private String providerId;
    private String providerType;
    private Date postedDate;
    private ArrayList otherData;
    private boolean stockAvailability;
    private String stateType;
    private int star;

}
