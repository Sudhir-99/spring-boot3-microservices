package com.sudhirmicro.department.service.repository;

import com.sudhirmicro.department.service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Long> {
    Department findByDepartmentId(Long departmentId);
}
