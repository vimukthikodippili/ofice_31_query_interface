package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnProductDTO {
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
  //  private boolean payedState;
    private boolean stockAvailability;
    private String stateType;
    private ReviewCountDetailsDTO reviewCountDetailsDTO;
   // private boolean verifyState;
}
