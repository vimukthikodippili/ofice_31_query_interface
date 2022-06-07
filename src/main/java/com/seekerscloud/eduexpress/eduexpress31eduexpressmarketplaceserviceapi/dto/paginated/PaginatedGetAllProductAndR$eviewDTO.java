package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnAllproductReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedGetAllProductAndR$eviewDTO {
    private List<ReturnAllproductReviewDTO> list;
    private long dataCount;
}
