package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestHotDealAdvertisementDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;

public interface HotDealAdvertisementService {
    String saveHotDealAdvertisement(RequestHotDealAdvertisementDTO dto, String prefix, String productId);
}
