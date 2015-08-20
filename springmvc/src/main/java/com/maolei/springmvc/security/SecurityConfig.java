package com.maolei.springmvc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.maolei.springmvc.service.IUserDetailService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password")
//				.roles("USER")
//				.and().passwordEncoder(new Md5PasswordEncoder());
		auth.userDetailsService(userDetailsService()).passwordEncoder(
				new Md5PasswordEncoder()).and().inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
 	    .csrf().disable()
 	    .authorizeRequests()
 	        .antMatchers("/login","/login/form**","/register","/logout").permitAll() // #4
 	        .antMatchers("/admin","/admin/**").hasRole("ADMIN") // #6
 	        .anyRequest().authenticated() // 7
 	        .and()
 	    .formLogin()  // #8
 	        .loginPage("/login") // #9
 	        .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
 	        .failureUrl("/login?error")
 	        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout/success").permitAll();
 	       // .permitAll(); // #5
    	 http.userDetailsService(userDetailsService());
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/static/**", "/**/*.jsp");
	}
    @Bean
	public IUserDetailService userDetailsService() {
		IUserDetailService userDetailsService = new IUserDetailService();
		return userDetailsService;
	}
    @Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// 设置内存用户角色
		// auth.inMemoryAuthentication().withUser("user").password("123456")
		// .roles("USER").and().withUser("admin").password("654321")
		// .roles("USER", "ADMIN");

		// 自定义UserDetailsService
		auth.userDetailsService(userDetailsService()).passwordEncoder(
				new Md5PasswordEncoder());

	}
}
