package com.example.springbootsample.domain.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootsample.domain.user.model.MUser;
import com.example.springbootsample.domain.user.service.UserService;
import com.example.springbootsample.repository.UserRepository;


@Service
@Primary
public class UserServiceImpl2 implements UserService { //-> JPA
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	/** ユーザー登録*/
	@Transactional
	@Override
	public void signup(MUser user) {
		
		//存在✓
		boolean exists = repository.existsById(user.getUserId());
		if(exists) {
			throw new DataAccessException("ユーザーが既に存在") {
				private static final long serialVersionUID = 1L;};
		}

		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		
		//Password 暗号化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		
		//insert
		repository.save(user);
	}
	
	/** ユーザー取得*/
	@Override
	public List<MUser> getUsers(MUser user) {

        //検索条件
		ExampleMatcher matcher = ExampleMatcher
				.matching() // and
				.withStringMatcher(StringMatcher.CONTAINING) //Like
				.withIgnoreCase(); //大文字・小文字の両方
		
		return repository.findAll(Example.of(user, matcher));
	}

	/** ユーザー取得（１件）*/
	@Override
	public MUser getUserOne(String userId) {
		Optional<MUser> option = repository.findById(userId);
		MUser user = option.orElse(null);
		return user;
	}
	
	
	/**ユーザー更新（１件）*/
	@Transactional
	@Override
	public void updateUserOne(String userId,String password,String userName) {
        //パスワード暗号化
		String encryptPassword = encoder.encode(password);

        //ユーザー更新
		repository.updateUser(userId, encryptPassword, userName);
		
		//Raise an exception
		//int i = 1 / 0;
		
	}
	
	/**ユーザー削除（１件）*/
    @Transactional
	@Override
	public void deleteUserOne(String userId) {
		repository.deleteById(userId);
	}
	
	/**ログインユーザー取得 */
    @Override
	public MUser getLoginUser(String userId) {
        return repository.findLoginUser(userId);
	}


}