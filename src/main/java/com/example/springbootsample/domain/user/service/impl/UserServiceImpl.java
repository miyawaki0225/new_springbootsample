package com.example.springbootsample.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootsample.domain.user.model.MUser;
import com.example.springbootsample.domain.user.service.UserService;
import com.example.springbootsample.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;
    
    /* ユーザー登録 */
    @Override
    public void signup(MUser user){
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        mapper.insertOne(user);
    }

    /* ユーザー取得 */
    @Override
    public List<MUser> getUsers(MUser user){
        return mapper.findMany(user);
    }

    /* ユーザー取得（１件） */
    @Override
    public MUser getUserOne(String userId){
        return mapper.findOne(userId);
    }

    //@Transactionlaを付けているとメソッド内で例外が発生すると、自動でロールバックされる
    /* ユーザー更新（１件） */
    @Transactional
    @Override
	public void updateUserOne(String userId,
			String password,
			String userName) {
		mapper.updateOne(userId, password, userName);
        // 例外を発生させる。
        // int i= 1/0;
	}

    /* ユーザー削除（１件）*/
    @Override
    public void deleteUserOne(String userId){
        mapper.deleteOne(userId);
    }
}
