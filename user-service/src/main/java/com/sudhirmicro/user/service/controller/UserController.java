package com.sudhirmicro.user.service.controller;

import com.netflix.discovery.converters.Auto;
import com.sudhirmicro.user.service.VO.ResponseTemplateVO;
import com.sudhirmicro.user.service.client.APIClient;
import com.sudhirmicro.user.service.entity.User;
import com.sudhirmicro.user.service.repository.UserRepository;
import com.sudhirmicro.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info(" Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info(" Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping("/department/{departmentId}")
    public User findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        log.info("User find: departmentId={}", departmentId);
        return userRepository.findByDepartmentId(departmentId);
    }

    @GetMapping("/details/{id}")
    public ResponseTemplateVO getUserWithDepartmentWithFeign(@PathVariable("id") Long userId){
        log.info(" Inside getUserWithDepartmentWithFeign method of UserController");
        return userService.getUserWithDepartmentWithFeignClient(userId);
    }

}