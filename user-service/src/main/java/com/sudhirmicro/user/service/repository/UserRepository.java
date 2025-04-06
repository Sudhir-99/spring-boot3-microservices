package com.sudhirmicro.user.service.repository;

import com.sudhirmicro.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserId(Long userId);

   User findByDepartmentId(Long departmentId);
}