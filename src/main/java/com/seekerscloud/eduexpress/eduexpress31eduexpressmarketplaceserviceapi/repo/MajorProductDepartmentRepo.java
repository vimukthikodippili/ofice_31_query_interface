package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.MajorProductDepartment;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MajorProductDepartmentRepo extends JpaRepository<MajorProductDepartment,String> {
    @Query(value = "select * from  major_product_department  ORDER BY RAND() limit 1",nativeQuery = true)
    List<MajorProductDepartment> getPropertyByDepartment();

}
