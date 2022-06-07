package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.api;

import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestMajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.requestDTO.RequestProductDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.ReturnMajorProductDepartmentDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.MajorProductDepartmentService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.service.ProductService;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/marketplace-majorproductdepartment")
@CrossOrigin
public class MajorProductDepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(MajorProductDepartmentController.class);

    @Autowired
    private MajorProductDepartmentService majorProductDepartmentService;

    @PostMapping(
            path = "/host/member/business/make-major-product-department")
    public ResponseEntity saveMajorProductDepartment(@RequestBody RequestMajorProductDepartmentDTO dto) {
        String id = majorProductDepartmentService.saveMajorProductDepartment(dto);
        return new ResponseEntity(new StandardResponse(201, id + "property successfully saved!", true),
                HttpStatus.CREATED);
    }
    @DeleteMapping(
            path = "host/member/business/delete-major-product-department",
            params = {"id"})
    public ResponseEntity deleteMajorProductDepartment(@RequestParam(value = "id") String id) {
        boolean delete = majorProductDepartmentService.deleteMajorProductDepartment(id);
        LOGGER.info("deleting the MajorProductDepartment, Id:" + id);
        return new ResponseEntity(new StandardResponse(200, "Success", delete), HttpStatus.OK);

    }
    @GetMapping(
            path = "/user/major-product-departments-by-random")
    public ResponseEntity getMajorProductDepartmentByRandom() {
        List<ReturnMajorProductDepartmentDTO> dto = majorProductDepartmentService.getMajorProductDepartment();
        return new ResponseEntity(new StandardResponse(200, "Success", dto), HttpStatus.OK);

    }
//    @PutMapping("/") // not necessery
//    public ResponseEntity updateBranch(@RequestBody BranchDto dto) {
//        BranchDto branch = service.updateBranch(dto);
//        return new ResponseEntity(new StandardResponse(204, "Success", branch), HttpStatus.OK);
//
//    }


}
