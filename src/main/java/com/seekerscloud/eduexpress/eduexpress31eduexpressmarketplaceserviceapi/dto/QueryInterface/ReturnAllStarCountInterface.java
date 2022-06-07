package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface ReturnAllStarCountInterface {
     String getProductId();
     ArrayList getAvailableCountries();
     boolean getWorldWideState();
     ArrayList getThumbNail();
     String getProductName();
     String getProductTitle();
     String getCatagory();
     Double getCost();
     String getProviderId();
     String getProviderType();
     Date getPostedDate();
     ArrayList getOtherData();
     boolean getStockAvailability();
     String getStateType();
     int getStar();
}
