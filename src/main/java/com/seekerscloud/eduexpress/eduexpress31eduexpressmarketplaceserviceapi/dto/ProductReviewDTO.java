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
public class ProductReviewDTO {

    private String propertyId;
    private String userId;
    private int star;
    private String comments;
    private Date reviewDate;
    private ArrayList avatar;
    private String userName;
    private ProductDTO products;

}
