package com.likehero.likeherotozero;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager users() {

        UserDetails scientist = User.withDefaultPasswordEncoder()
                .username("scientist")
                .password("climate123")
                .roles("SCIENTIST")
                .build();

        return new InMemoryUserDetailsManager(scientist);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/admin", true)
                .permitAll()
            )
            .logout(logout -> logout.logoutSuccessUrl("/"))
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}