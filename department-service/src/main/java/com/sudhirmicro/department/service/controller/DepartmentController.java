package com.sudhirmicro.department.service.controller;

import com.netflix.discovery.converters.Auto;
import com.sudhirmicro.department.service.VO.ResponseTemplateVO;
import com.sudhirmicro.department.service.client.UserClient;
import com.sudhirmicro.department.service.entity.Department;
import com.sudhirmicro.department.service.repository.DepartmentRepository;
import com.sudhirmicro.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserClient userClient;


    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("saveDepartment called from Department Controller");
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("findDepartmentById called from Department Controller");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/with-users/{id}")
    public ResponseTemplateVO findAllDepartmentsWithUsers(@PathVariable("id") Long departmentId){

        log.info("find all departments with users");
        Department departments = departmentService.findDepartmentById(departmentId);

        ResponseTemplateVO finalResponse = new ResponseTemplateVO();
        finalResponse.setDepartment(departments);
        finalResponse.setUser(userClient.findByDepartmentId(departmentId));
        return finalResponse;
    }


}