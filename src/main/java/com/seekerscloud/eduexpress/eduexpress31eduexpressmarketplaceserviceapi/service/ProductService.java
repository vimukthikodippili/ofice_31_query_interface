package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedAllstarCountDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedGetAllProductAndR$eviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedProductandProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;

public interface ProductService {
    public String saveProduct(RequestProductDTO dto,String prefix,String propertyId);

    String saveProducts(RequestProductDTO dto, String prefix, String propertyId);
   // PaginatedGetAllProductAndR$eviewDTO List<ReturnAllproductReviewDTO> void getAllProductAndReview();
   PaginatedGetAllProductAndR$eviewDTO getAllProductandReview(int page, int size);

   PaginatedProductandProductCatagoryDTO getAllProductCatagory(int page, int size);
   PaginatedAllstarCountDTO getAllStarCount(String searchTextint,String Productcategory,int page, int size);
}
