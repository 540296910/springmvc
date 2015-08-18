package com.maolei.springmvc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
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
 	        .loginPage("/login/form") // #9
 	        .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
 	        .failureUrl("/login/form?error")
 	        .permitAll(); // #5
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/static/**", "/**/*.jsp");

	}
}
