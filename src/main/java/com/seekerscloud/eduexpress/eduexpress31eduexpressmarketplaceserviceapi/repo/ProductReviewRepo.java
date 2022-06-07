package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductReviewRepo extends JpaRepository<ProductReview,String> {

    @Query(value = "SELECT property_id FROM ProductReview\n" +
            "where property_id like ?%\n" +
            "order by cast(substring(property_id,?) as unsigned) desc limit 1;\n", nativeQuery = true)

    String findLastUserId(String userId,int value);

}
