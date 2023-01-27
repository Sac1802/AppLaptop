package com.example.AppLaptop.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityCongif {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/api/laptop/get").permitAll()
                .requestMatchers("/api/laptop/getid/{id}").permitAll()
                .requestMatchers("/api/laptop/post").hasRole("ADMIN")
                .requestMatchers("/api/laptop/update").hasRole("ADMIN")
                .requestMatchers("/api/laptop/delete").hasRole("ADMIN")
                .requestMatchers("/api/laptop/deleteid/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin@123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder result = new  BCryptPasswordEncoder(16);
        return result;
    }
}
