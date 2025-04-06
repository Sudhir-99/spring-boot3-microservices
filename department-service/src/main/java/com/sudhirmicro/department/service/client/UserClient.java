package com.sudhirmicro.department.service.client;

import com.sudhirmicro.department.service.VO.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface UserClient {

    @GetExchange("/user/department/{departmentId}")
    public User findByDepartmentId(@PathVariable("departmentId") Long departmentId);

}
