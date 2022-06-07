package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.HotDealAdvertisementDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestHotDealAdvertisementDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.NotFoundException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.HotDealAdvertisementRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.HotDealAdvertisementService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.Generator;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.HotDealAdvertisementMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class HotDealAdvertisementServiceImpl implements HotDealAdvertisementService {
    @Autowired
    private Generator generator;

    @Autowired
    private HotDealAdvertisementMapper hotDealAdvertisementMapper;

    @Autowired
    private HotDealAdvertisementRepo hotDealAdvertisementRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveHotDealAdvertisement(RequestHotDealAdvertisementDTO dto, String prefix, String productId) {
        String propertyId = generator.createProductIdHotDeal(prefix);
        Product product = productRepo.getById(productId);
        System.out.println("wwwww "+product.getProductId());
        HotDealAdvertisementDTO hotDealAdvertisementDTO = new HotDealAdvertisementDTO(
                propertyId,
                dto.getVisibleCountry(),
                dto.getVisibleState(),
                dto.getDealEnd(),
                dto.getTitle(),
                dto.getDealType(),
                dto.getButtonText(),
                dto.getRedirectLink(),
                dto.getImages(),
                dto.getOtherData(),
                true,
                true,
                true,
                dto.getProviderId(),
                dto.getProviderType(),
                dto.getPackageName(),
                dto.getDuration(),
                dto.getCost(),
                dto.getReaches(),
                dto.isBoostedState(),
                dto.getBoostingHistory(),
                dto.getBoostedFrom(),
                dto.getBoostedUtil(),
                dto.getInitialTargetReaches(),
                modelMapper.map(productRepo.getById(productId), ProductDTO.class));








        if (!hotDealAdvertisementRepo.existsById(hotDealAdvertisementDTO.getPropertyId())) {
            return hotDealAdvertisementRepo.save(hotDealAdvertisementMapper.toHotDealAdvertisement(hotDealAdvertisementDTO)).getPropertyId() ;
        } else {
            throw new NotFoundException("Already Exists");
        }
    }
}
