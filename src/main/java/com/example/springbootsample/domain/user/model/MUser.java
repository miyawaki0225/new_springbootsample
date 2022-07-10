package com.example.springbootsample.domain.user.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MUser {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gendar;
    private Integer departmentId;
    private String role;
    private Department department;
    private List<Salary>salaryList;
}
