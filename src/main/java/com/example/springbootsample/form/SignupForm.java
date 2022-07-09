package com.example.springbootsample.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//対象クラスにgetter/setterでアクセスすることを可能とします。
//equals()メソッドやtoString()メソッドが使えるようになります。
@Data
public class SignupForm {
    @NotBlank(groups=ValidGroup1.class)
    @Email(groups=ValidGroup2.class)
    private String userId;

    //@NotBlank。文字列に空白文字(半角スペース・タブ文字)以外が含まれていることをチェックします。
    //@Length。Stringの値に利用され、文字列の長さ（文字数）の範囲を指定する。
    //@Pattern。文字列が引数として渡した正規表現と一致するかどうかチェックします。
    @NotBlank(groups=ValidGroup1.class)
    @Length(min=4,max=100,groups=ValidGroup2.class)
    @Pattern(regexp="^[a-zA-Z0-9]+$",groups=ValidGroup2.class)   
    private String password;
    
    @NotBlank(groups=ValidGroup1.class)
    private String userName;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    @NotNull(groups=ValidGroup1.class)
    private Date birthday;
    
    @Min(value=20, groups=ValidGroup2.class)
    @Max(value=100, groups=ValidGroup2.class)
    private Integer age;
    
    @NotNull(groups=ValidGroup1.class)
    private Integer gender;
    
}
