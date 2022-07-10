package com.example.springbootsample.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springbootsample.domain.user.model.MUser;

@Mapper
public interface UserMapper {
    /* ユーザー登録 */
    public int insertOne(MUser user);
    /* ユーザー取得 */
    public List<MUser>findMany();
    /* ユーザー取得（１件） */
    public MUser findOne(String userId);

    /*@Param　複数のパラメータを使用する場合、メソッドの引数に@Paramアノテーションをつける */
    /* ユーザー削除（１件） */
    public int deleteOne(@Param("userId") String userId);
}
