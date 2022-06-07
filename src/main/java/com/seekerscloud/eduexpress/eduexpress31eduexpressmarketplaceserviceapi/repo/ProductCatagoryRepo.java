package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.ProductCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductCatagoryRepo extends JpaRepository<ProductCatagory,String> {
}
