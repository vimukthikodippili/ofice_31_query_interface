package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity;

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
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_review")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class  ProductReview implements SuperEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(45)")
    @NotNull(message = "product id is required")
    private String propertyId;

    @Column(name = "user_id")
//    @Size(min = 3,max = 45,message = "user id greater 3 and less  than 45")
    private String userId;

    @Column(columnDefinition = "INT")
    @NotNull(message = "star is required")
    private int star;

    @Column(name = "comments")
//    @Size(min = 3,max = 255,message = "comments greater 3 and less  than 45")
    private String comments;

    @Column(columnDefinition = "DATETIME")
    @NotNull(message = "review date is required")
    private Date reviewDate;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @NotNull(message = "avatar is required")
    private ArrayList avatar;

    @Column(name = "usename")
//    @Size(min = 3,max = 100,message = "user name 3 and less  than 45")
    private String userName;


//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "productId", referencedColumnName = "productId")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Product productId;
@ManyToOne
@JoinColumn(name="productId", nullable=false)
private Product products;


}
