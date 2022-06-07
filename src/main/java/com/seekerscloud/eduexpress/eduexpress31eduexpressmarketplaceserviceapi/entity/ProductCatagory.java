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
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_catagory")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class ProductCatagory implements SuperEntity{
    @Id
    @Column(columnDefinition = "VARCHAR(45)")
    @NotNull(message = "product id is required")
    private String ProductCatagoryId;

    @Column(name = "catagory")
    @Size(min = 3,max = 45,message = "category 3 and less  than 45")
    private String catagory;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "other data is required")
    private ArrayList otherData;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "thumb nail is required")
    private ArrayList thumbNail;

    @OneToMany(mappedBy="productCategories")
    private Set<Product> products;


//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private MajorProductDepartment majorProductDepartment;

//    @JsonIgnore
//    @OneToMany(mappedBy = "propertyId", cascade = {CascadeType.ALL})
//    private List<HotDealAdvertisement> hotDealAdvertisements = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MajorProductDepartment majorProductDepartment;



}
