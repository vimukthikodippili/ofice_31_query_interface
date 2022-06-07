package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
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
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Product implements SuperEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(45)")
    @NotNull(message = "product id is required")
    private String productId;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "available countries is required")
    private ArrayList availableCountries;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean worldWideState;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "thumb nail is required")
    private ArrayList thumbNail;

    @Column(name = "product_name")
//    @Size(min = 3,max = 45,message = "product name greater 3 and less  than 45")
    private String productName;

    @Column(name = "product_title")
    //@Size(min = 3,max = 45,message = "product name greater 3 and less  than 45")
    private String productTitle;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "provider_id")
   // @Size(min = 3,max = 45,message = "provider id greater 3 and less  than 45")
    private String providerId;

    @Column(name = "product_type")
//    @Size(min = 3,max = 45,message = "product type greater 3 and less  than 45")
    private String providerType;

    @Column(columnDefinition = "DATETIME")
    @NotNull(message = "post date date is required")
    private Date postedDate;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "other data is required")
    private ArrayList otherData;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean payedState;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean stockAvailability;

    @Column(name = "state_type")
    @Size(min = 3,max = 45,message = "state type greater 3 and less  than 45")
    private String stateType;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean verifyState;

//    @JsonIgnore
//    @OneToMany(mappedBy = "propertyId", cascade = {CascadeType.ALL})
//    private List<ProductReview> productReviews = new ArrayList<>();

    @OneToMany(mappedBy="products")
    private Set<ProductReview> productReviews;

    @JsonIgnore
    @OneToMany(mappedBy = "propertyId", cascade = {CascadeType.ALL})
    private List<HotDealAdvertisement> hotDealAdvertisements = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="productCategoryId", nullable=false)
    private ProductCatagory productCategories;



}
