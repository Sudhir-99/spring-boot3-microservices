package com.sudhirmicro.department.service.service;

import com.sudhirmicro.department.service.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department findDepartmentById(Long departmentId);
}