package com.example.springbootsample.domain.user.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="m_department")
public class Department {
    private Integer departmentId;
	private String departmentName;
}
