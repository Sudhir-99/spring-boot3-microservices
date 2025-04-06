package com.sudhirmicro.department.service.service;

import com.sudhirmicro.department.service.entity.Department;
import com.sudhirmicro.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("saveDepartment called from Department Service Implementation");
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        log.info("findDepartmentById called from Department Service Implementation");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}