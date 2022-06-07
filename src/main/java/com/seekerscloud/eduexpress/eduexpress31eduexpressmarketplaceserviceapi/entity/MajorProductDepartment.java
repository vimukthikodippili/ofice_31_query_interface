package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Major_product_department")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class MajorProductDepartment implements SuperEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(45)")
    @NotNull(message = "product id is required")
    private String propertyId;

    @Column(name = "type_name")
    @Size(min = 3,max = 45,message = "type name greater 3 and less  than 45")
    private String typeName;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "other data is required")
    private ArrayList otherData;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @Column(name = "icon_name")
    @Size(min = 3,max = 45,message = "icon greater 3 and less  than 45")
    private String icon;



    @JsonIgnore
    @OneToMany(mappedBy = "ProductCatagoryId", cascade = {CascadeType.ALL})
    private List<ProductCatagory> productCatagory = new ArrayList<>();
}
