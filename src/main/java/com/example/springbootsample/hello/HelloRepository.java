package com.example.springbootsample.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//データ層のクラスに付与し、DAO等のDBアクセスを行います。付与することでSpirngのコンポーネントとして認識され、ApplicationContextに登録されます。
@Repository
public class HelloRepository {
    //特定のアノテーションを付与したクラスのインスタンスを使用できるようにする
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Map<String, Object>findById(String id){
        String query = "SELECT * FROM employee WHERE id = ?";
        Map<String,Object> employee = jdbcTemplate.queryForMap(query,id);
        return employee;
    }
}
