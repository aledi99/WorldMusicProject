package com.salesianostriana.dam.proyectofinal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityWeb extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	
	public SecurityWeb(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		/*auth
		.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("admin@admin.com")
		.password("admin")
		.roles("ADMIN");*/
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/css/**","/js/**","/webjars/**", "/styles/**", "/img/**", "/fonts/**", "/scripts/**", "/h2-console/**").permitAll()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/logout")
			.permitAll().
			 and()
			.exceptionHandling()
			.accessDeniedPage("/acceso-denegado");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
	}
}
