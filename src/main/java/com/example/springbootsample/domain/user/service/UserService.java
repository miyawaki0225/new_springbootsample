package com.example.springbootsample.domain.user.service;

import java.util.List;

import com.example.springbootsample.domain.user.model.MUser;

public interface UserService {
    //ユーザー登録
    public void signup(MUser user);
    //ユーザー取得
    public List<MUser> getUsers();
}
