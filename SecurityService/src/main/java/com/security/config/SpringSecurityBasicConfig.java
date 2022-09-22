package com.security.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityBasicConfig  {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.httpBasic().and().authorizeHttpRequests()
//		.antMatchers(HttpMethod.POST,"/post").hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.PUT,"/put/**").hasAnyRole("ADMIN","USER")
//		.antMatchers(HttpMethod.GET,"/get").hasAnyRole("USER").and().csrf().disable().headers()
//		.frameOptions().disable();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user123").password("{noop}password").roles("USER").and()
//		.withUser("admin123").password("{noop}password").roles("ADMIN").and().withUser("test123")
//		.password("{noop}password").roles("USER").and().withUser("admin1").password("{noop}password")
//		.roles("ADMIN");
//	}
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		List<UserDetails> userDetailsList;
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user123")
            .password("password")
            .roles("USER")
            .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("admin123")
                .password("password")
                .roles("ADMIN")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("test123")
                .password("password")
                .roles("USER")
                .build();
        UserDetails user4 = User.withDefaultPasswordEncoder()
                .username("admin1")
                .password("password")
                .roles("ADMIN")
                .build();
        userDetailsList = (List<UserDetails>) Arrays.asList(user,user2,user3,user4);
        return new InMemoryUserDetailsManager(userDetailsList);
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests()
		.antMatchers(HttpMethod.POST,"/post").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/put/**").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET,"/get/**").hasAnyRole("USER").and().csrf().disable().headers()
		.frameOptions().disable();
        return http.build();
    }

}
