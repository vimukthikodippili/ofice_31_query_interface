package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotDealAdvertisementDTO {

    private String propertyId;
    private ArrayList visibleCountry;
    private ArrayList visibleState;
    private Date DealEnd;
    private String title;
    private String dealType;
    private String buttonText;
    private ArrayList redirectLink;
    private ArrayList images;
    private ArrayList otherData;
    private boolean activeState;
    private boolean paidState;
    private boolean verifyState;
    private String providerId;
    private String providerType;
    private String packageName;
    private int duration;
    private Double cost;
    private int reaches;
    private boolean boostedState;
    private ArrayList boostingHistory;
    private Date boostedFrom;
    private Date boostedUtil;
    private int initialTargetReaches;
    private ProductDTO productId;
}
