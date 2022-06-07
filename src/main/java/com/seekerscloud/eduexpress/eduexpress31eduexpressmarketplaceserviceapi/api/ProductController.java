package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.api;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedAllstarCountDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedGetAllProductAndR$eviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.paginated.PaginatedProductandProductCatagoryDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnAllproductReviewDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/marketplace-products")
@CrossOrigin
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping(
            path = {"/admin/member/business/save-product"},
            params ={ "prefix","propertyId"})
    public ResponseEntity saveProduct(
           @Valid @RequestBody RequestProductDTO dto,
            @RequestParam(value = "prefix") String prefix,
            @RequestParam(value = "propertyId") String propertyId) {
        String id = productService.saveProduct(dto, prefix,propertyId);
        return new ResponseEntity(new StandardResponse(201, id + " property successfully saved!", true),
                HttpStatus.CREATED);
    }
//    @GetMapping()
//    public ResponseEntity getAllProdutAndReview(  @RequestParam(value = "page") int page,
//                                                  @RequestParam(value = "size") @Max(50) int size) {
//        PaginatedGetAllProductAndR$eviewDTO returnAllproductReviewDTOS = productService.getAllProductandReview(page, size);
//        return new ResponseEntity(new StandardResponse(200, "Success", returnAllproductReviewDTOS), HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity getAllProductAndCatagory(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "searchText") String searchText,
            @RequestParam(value = "Product-category") String Productcategory


    ){
        PaginatedProductandProductCatagoryDTO paginatedProductandProductCatagoryDTO=productService.getAllProductCatagory(page,size);
        return new ResponseEntity(new StandardResponse(200,"success",paginatedProductandProductCatagoryDTO),HttpStatus.OK);

    }

    @GetMapping(
            path = "/user/ products-by-category"
    )
    public ResponseEntity getProductByCategory(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "product-catagory") String productCatagory,
            @RequestParam(value = "SearchText")String searchText

    ){
        PaginatedAllstarCountDTO paginatedAllstarCountDTO=productService.getAllStarCount(searchText,productCatagory,page,size);
        return new ResponseEntity(new StandardResponse(200,"success",paginatedAllstarCountDTO),HttpStatus.OK);

    }








}
