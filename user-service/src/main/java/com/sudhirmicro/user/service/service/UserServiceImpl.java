package com.sudhirmicro.user.service.service;

import com.sudhirmicro.user.service.VO.Department;
import com.sudhirmicro.user.service.VO.ResponseTemplateVO;
import com.sudhirmicro.user.service.client.APIClient;
import com.sudhirmicro.user.service.entity.User;
import com.sudhirmicro.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private APIClient apiClient;

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser method of UserServiceImpl");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserServiceImpl");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }


    @Override
    public ResponseTemplateVO getUserWithDepartmentWithFeignClient(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = apiClient.findDepartmentById(user.getDepartmentId());

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

}