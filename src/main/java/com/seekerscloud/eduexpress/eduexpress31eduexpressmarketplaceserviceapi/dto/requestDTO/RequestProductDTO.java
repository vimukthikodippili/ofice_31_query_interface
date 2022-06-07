package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDTO implements SuperDTO {

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


}
