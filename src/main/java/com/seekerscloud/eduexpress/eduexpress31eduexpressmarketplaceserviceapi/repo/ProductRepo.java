package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllProductandProductCatagoryInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllStarCountInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.QueryInterface.ReturnAllproductReviewInterface;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,String> {
    @Query(value = "SELECT product_id FROM product\n" +
            "where product_id like ?%\n" +
            "order by cast(substring(product_id,?) as unsigned) desc limit 1;\n", nativeQuery = true)
    String findLastId(String prefix,int value);

    @Query(value = "SELECT p.product_id as productId,p.available_countries as availableCountries,p.world_wide_state as worldWideState,pr.property_id as propertyId,pr.user_id as userId,pr.star as star FROM product p,product_review pr where p.product_id=pr.product_id",nativeQuery = true)
    List<ReturnAllproductReviewInterface> getAllPropertiesForHostAll(Pageable of);







    @Query(value="SELECT COUNT(*) FROM product,product_review  ",nativeQuery = true)
    long countAllPropertiesForHostAll();

    //product catagory query


    @Query(value = "SELECT p.product_id as productId,p.available_countries as availableCountries,p.world_wide_state as worldWideState,pc.product_catagory_id as ProductCatagoryId,pc.catagory as catagory,pc.active_state as activeState FROM product p, product_catagory pc where p.product_category_id=pc.product_catagory_id",nativeQuery = true)
    List<ReturnAllProductandProductCatagoryInterface> getAllproductCatagory(Pageable of);

    @Query(value="SELECT COUNT(*) FROM product, product_catagory",nativeQuery = true)
    long countAllproductCatagory();

 //////////////star count ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 @Query(value = "SELECT p.product_id as productId,p.available_countries as availableCountries,p.world_wide_state as worldWideState,p.thumb_nail as thumbNail,p.product_name as productName,p.product_title as productTitle,pc.catagory as catagory,p.cost as cost,p.provider_id as providerId,p.product_type as providerType,p.posted_date as postedDate,p.other_data as otherData,p.stock_availability as stockAvailability,p.state_type as stateType,pr.star as star FROM product p, product_catagory pc,product_review pr where p.product_category_id=pc.product_catagory_id=?2 and p.product_id=pr.product_id and(product_title like %?1%)",nativeQuery = true)
 List<ReturnAllStarCountInterface> getAllStarCount(String searchText,String catagory,Pageable of);

    @Query(value="select count(property_id) as countsss,star from product_review group by star;",nativeQuery = true)
    long countAllStarFromProduct();






}
