package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnAllProductandProductCatagoryDTO {
    private String productId;
    private ArrayList availableCountries;
    private boolean worldWideState;
    private String ProductCatagoryId;
    private String catagory;
    private boolean activeState;
}
