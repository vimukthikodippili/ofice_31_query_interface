package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.HotDealAdvertisementDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.HotDealAdvertisement;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotDealAdvertisementMapper {
    HotDealAdvertisement toHotDealAdvertisement(HotDealAdvertisementDTO hotDealAdvertisementDTO);
    HotDealAdvertisementDTO toHotDealAdvertisementDTO(HotDealAdvertisement hotDealAdvertisement);
    List<HotDealAdvertisementDTO> pageToHotDealAdvertisementDTO(Page<HotDealAdvertisement> hotDealAdvertisements);
    List<HotDealAdvertisement> toHotDealAdvertisement(List<HotDealAdvertisementDTO> hotDealAdvertisementDTOS);
}
