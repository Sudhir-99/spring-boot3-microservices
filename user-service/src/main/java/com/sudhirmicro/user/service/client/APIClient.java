package com.sudhirmicro.user.service.client;

import com.sudhirmicro.user.service.VO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "department-service",url = "http://localhost:9001")
public interface APIClient {

    @GetMapping(value = "/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId);
}
