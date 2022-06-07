package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hot_deal_advertisement")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class HotDealAdvertisement implements SuperEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(45)")
    @NotNull(message = "product id is required")
    private String propertyId;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "visible country is required")
    private ArrayList visibleCountry;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "visible state is required")
    private ArrayList visibleState;

    @Column(columnDefinition = "DATETIME")
    @NotNull(message = "deal end date is required")
    private Date DealEnd;

    @Column(name = "title")
    @Size(min = 3,max = 45,message = "title 3 and less  than 45")
    private String title;

    @Column(name = "deal_type")
    @Size(min = 3,max = 45,message = "deal type 3 and less  than 45")
    private String dealType;

    @Column(name = "button_text")
    @Size(min = 3,max = 45,message = "button text greater 3 and less  than 45")
    private String buttonText;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "redirect link is required")
    private ArrayList redirectLink;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "images is required")
    private ArrayList images;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "other data is required")
    private ArrayList otherData;


    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Column(columnDefinition = "TINYINT")
    private boolean paidState;

    @Column(columnDefinition = "TINYINT")
    private boolean verifyState;

    @Column(name = "provider_id")
    @Size(min = 3,max = 45,message = "provider id 3 and less  than 45")
    private String providerId;

    @Column(name = "provider_type")
    @Size(min = 3,max = 45,message = "provider type 3 and less  than 45")
    private String providerType;

    @Column(name = "package_name")
    @Size(min = 3,max = 45,message = "package name 3 and less  than 45")
    private String packageName;

    @Column(columnDefinition = "INT")
    @NotNull(message = "duration is required")
    private int duration;

    @Column(name = "cost")
    private Double cost;

    @Column(columnDefinition = "INT")
    @NotNull(message = "reaches is required")
    private int reaches;

    @Column(columnDefinition = "TINYINT")
    private boolean boostedState;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "boosting history is required")
    private ArrayList boostingHistory;

    @Column(columnDefinition = "DATETIME")
    @NotNull(message = "deal end date is required")
    private Date boostedFrom;

    @Column(columnDefinition = "DATETIME")
    @NotNull(message = "deal end date is required")
    private Date boostedUtil;

    @Column(columnDefinition = "INT")
    @NotNull(message = "initial is required")
    private int initialTargetReaches;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product productId;


}
