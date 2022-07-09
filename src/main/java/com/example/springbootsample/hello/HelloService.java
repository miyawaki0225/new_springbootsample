package com.example.springbootsample.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ビジネスロジック・アルゴリズム等が書かれた処理を提供します。
//付与することでSpirngのコンポーネントとして認識され、ApplicationContextに登録されます。
@Service
public class HelloService {
    @Autowired
    private HelloRepository repository;    

    public Employee getEmployee(String id){
        Map<String, Object>map = repository.findById(id);
        String employeeId = (String)map .get("id");
        String name = (String)map.get("name");
        int age= (Integer)map.get("age");

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(name);
        employee.setEmployeeAge(age);

        return employee;
    }
}
