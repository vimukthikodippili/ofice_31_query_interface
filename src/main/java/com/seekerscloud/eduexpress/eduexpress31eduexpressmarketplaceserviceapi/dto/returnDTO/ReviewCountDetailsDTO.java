package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReviewCountDetailsDTO {
    private int ReviewCount;
    private int ReviewStarCountIs1;
    private int ReviewStarCountIs2;
    private int ReviewStarCountIs3;
    private int ReviewStarCountIs4;
    private int ReviewStarCountIs5;
}
