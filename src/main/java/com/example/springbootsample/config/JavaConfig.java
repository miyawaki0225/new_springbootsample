package com.example.springbootsample.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//Configurationクラスでは、クラスに@Configurationを、
//メソッドに@Beanを付与します。
//@Beanを付与したメソッドに、Bean定義したいオブジェクトをreturnするように実装します。
@Configuration
public class JavaConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
}
