package com.sudhirmicro.department.service.VO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}