package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.impl;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.ProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllProductandProductCatagoryInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllStarCountInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllproductReviewInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedAllstarCountDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedGetAllProductAndR$eviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedProductandProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnAllProductandProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnAllStarCountProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnAllproductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.NotFoundException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductCatagoryRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.Generator;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Generator generator;

    @Autowired
   private ProductRepo productRepo;

    @Autowired
    private ProductCatagoryRepo productCatagoryRepo;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveProduct(RequestProductDTO dto, String prefix,String propertyId) {
        String productId = generator.createProductId(prefix);
        System.out.println("ppp "+propertyId+"    ooo"+productId);

        ProductCatagory productCatagory = productCatagoryRepo.getById(propertyId);
        System.out.println("AAAAAAAAAAAAAAAAA " +productCatagory.getProductCatagoryId());

        ProductDTO productDTO = new ProductDTO(
                productId,
                dto.getAvailableCountries(),
                dto.isWorldWideState(),
                dto.getThumbNail(),
                dto.getProductName(),
                dto.getProductTitle(),
                dto.getCost(),
                dto.getProviderId(),
                dto.getProviderType(),
                dto.getPostedDate(),
                dto.isActiveState(),
                dto.getOtherData(),
                dto.isPayedState(),
                dto.isStockAvailability(),
                dto.getStateType(),
                true,
                modelMapper.map(productCatagoryRepo.getById(propertyId),ProductCatagoryDTO.class)

        );

        if (!productRepo.existsById(productDTO.getProductId())) {
            return productRepo.save(productMapper.toProduct(productDTO)).getProductId();
        } else {
            throw new NotFoundException("Already Exists");
        }

    }

    @Override
    public String saveProducts(RequestProductDTO dto, String prefix, String propertyId) {
        return null;
    }

    @Override
    public PaginatedGetAllProductAndR$eviewDTO getAllProductandReview(int page, int size) {
        List<ReturnAllproductReviewInterface> selectedLecturingMediumGlobalGetInterfaces = productRepo.getAllPropertiesForHostAll(
                 PageRequest.of(page, size));
        System.out.println("datta "+selectedLecturingMediumGlobalGetInterfaces.get(0).getProductId());


        List<ReturnAllproductReviewDTO> list = new ArrayList<>();
        boolean b=false;
        for (ReturnAllproductReviewInterface c : selectedLecturingMediumGlobalGetInterfaces) {
            if (c.getWorldWideState()=='1'){
                b=true;
            }


            list.add(new ReturnAllproductReviewDTO(
                    c.getProductId(),c.getAvailableCountries(),b,c.getPropertyId1(),c.getUserId(),c.getStar()
            ));

        }

        return new PaginatedGetAllProductAndR$eviewDTO(
                list,
                productRepo.countAllPropertiesForHostAll());

    }

    @Override
    public PaginatedProductandProductCatagoryDTO getAllProductCatagory(int page, int size) {

        List<ReturnAllProductandProductCatagoryInterface> returnAllProductandProductCatagoryInterfaces=productRepo.getAllproductCatagory(PageRequest.of(page, size));
        System.out.println("datta "+returnAllProductandProductCatagoryInterfaces.get(0).getProductId());
        List<ReturnAllProductandProductCatagoryDTO> list = new ArrayList<>();
        for (ReturnAllProductandProductCatagoryInterface v: returnAllProductandProductCatagoryInterfaces) {

            list.add(new ReturnAllProductandProductCatagoryDTO(
                    v.getProductId(),v.getAvailableCountries(),true,v.getProductCatagoryId(),v.getCatagory(),true
            ));

        }
        return new PaginatedProductandProductCatagoryDTO(
                list,
                productRepo.countAllproductCatagory());



    }

    @Override
    public PaginatedAllstarCountDTO getAllStarCount(String searchTextint,String Productcategory,int page, int size) {
        List<ReturnAllStarCountInterface> returnAllStarCountInterfaces=productRepo.getAllStarCount( searchTextint,Productcategory,PageRequest.of(page, size));
        List<ReturnAllStarCountProductDTO> list = new ArrayList<>();
        for (ReturnAllStarCountInterface b:returnAllStarCountInterfaces) {
            list.add(new ReturnAllStarCountProductDTO(
                    b.getProductId(),
                    b.getAvailableCountries(),
                    true,
                    b.getThumbNail(),
                    b.getProductName(),
                    b.getProductTitle(),
                    b.getCatagory(),
                    b.getCost(),
                    b.getProviderId(),
                    b.getProviderType(),
                    b.getPostedDate(),
                    b.getOtherData(),
                    b.getStockAvailability(),
                    b.getStateType(),
                    b.getStar()


            ));


        }
        return new PaginatedAllstarCountDTO(
                list,
                productRepo.countAllStarFromProduct()
        );

    }


}
