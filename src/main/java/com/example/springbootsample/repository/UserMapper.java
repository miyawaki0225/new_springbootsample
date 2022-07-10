package com.example.springbootsample.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springbootsample.domain.user.model.MUser;

@Mapper
public interface UserMapper {
    public int insertOne(MUser user);

    public List<MUser>findMany();
}
