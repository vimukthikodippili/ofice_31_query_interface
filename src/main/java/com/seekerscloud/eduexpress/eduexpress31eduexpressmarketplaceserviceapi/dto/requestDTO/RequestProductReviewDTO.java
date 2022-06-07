package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductReviewDTO {

   // private String propertyId;
   // private String userId;
    private int star;
    private String comments;
    private Date reviewDate;
    private ArrayList avatar;
    private String userName;
}
