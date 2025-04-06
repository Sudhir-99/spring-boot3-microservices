package com.sudhirmicro.user.service.service;

import com.sudhirmicro.user.service.VO.ResponseTemplateVO;
import com.sudhirmicro.user.service.entity.User;

public interface UserService {

    public User saveUser(User user);

    ResponseTemplateVO getUserWithDepartment(Long userId);

    ResponseTemplateVO getUserWithDepartmentWithFeignClient(Long userId);
}