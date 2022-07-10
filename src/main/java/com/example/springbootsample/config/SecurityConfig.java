package com.example.springbootsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//The type WebSecurityConfigurerAdapter is deprecatedJava(16777221)
//@EnableWebSecurity

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	
	/** セキュリティの対象外を設定 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		//セキュリティを適用しない
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/h2-console/**");

	}
	
	/** セキュリティの各種設定 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ログイン不用ページの設定
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll() //Direct link OK
				.antMatchers("/user/signup").permitAll() //Direct link OK
				.antMatchers("/user/signup/rest").permitAll() //Direct link OK
				.antMatchers("/admin").hasAuthority("ROLE_ADMIN") //権限制御
				.anyRequest().authenticated(); //それ以外は直リンクNG
		
		//ログイン処理
		http
			.formLogin()
				.loginProcessingUrl("/login") //Login process path
				.loginPage("/login") //specify login page
				.failureUrl("/login?error") //Transition destination when login fails
				.usernameParameter("userId") //Login page user ID
				.passwordParameter("password") //Login page password
				.defaultSuccessUrl("/user/list", true); //Transition destination after success（成功後の遷移先）
		
		//ログアウト処理
		http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");
		
		//CSRF対策を無効に設定（一時的）
		//http.csrf().disable();
	}
	
	/** 認証の設定 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// インメモリ認証
		/*auth
			.inMemoryAuthentication()
				.withUser("user") //add user
				.password(encoder.encode("user"))
				.roles("GENERAL")
			.and()
				.withUser("admin") //add admin
				.password(encoder.encode("admin"))
				.roles("ADMIN");
				*/
		PasswordEncoder encoder = passwordEncoder();
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder);
	}
}
