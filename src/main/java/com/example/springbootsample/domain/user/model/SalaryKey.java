package com.example.springbootsample.domain.user.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SalaryKey implements Serializable {  //JPA
	
	private String userId;
	private String yearMonth;

}
