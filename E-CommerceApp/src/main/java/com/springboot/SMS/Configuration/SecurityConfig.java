package com.springboot.SMS.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.SMS.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		
		//.requestMatchers("/home/public")
		.requestMatchers("/","/shop/**","/register","/h2-console") 
		.permitAll()
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.failureUrl("/login?error=true")
		.defaultSuccessUrl("/")
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		.oauth2Login()
		.loginPage("/login")
		.successHandler(googleOAuth2SuccessHandler)
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.and()
		.exceptionHandling()
		.and()
		.csrf()
		.disable();
		
		httpSecurity.headers().frameOptions().disable();
		
		return httpSecurity.build();
		
	
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailService);
	}
	
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().requestMatchers("/resources/**","/static/**","/images/**","/productImages/**","/css/**","/js/**");
	}

	
	
	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails normalUser = User
//				.withUsername("sakshi")
//				.password(bCryptPasswordEncoder().encode("password"))
//				.roles("Role_Normal")
//				.build();
//		
//		
//		UserDetails adminUser = User
//				.withUsername("Sakshigoyal")
//				.password(bCryptPasswordEncoder().encode("password"))
//				.roles("Role_Admin")
//				.build();
//		
//		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser, adminUser);
//		return inMemoryUserDetailsManager;
//				
////	}
//	
//	
//	
	
	
	
	
	
	
	
}