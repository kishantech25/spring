package com.nt.security.config;

import com.nt.security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailService myUserDetailService;


    @Bean
    public AuthenticationProvider authProvider() {
        // Setter method of DaoAuthenticationProvider is deprecated
        // Constructor is used
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider(myUserDetailService);
      //  PasswordEncoder passwordEncoder = passwordEncoder();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        // NoPasswordEncoder is Deprecated. In this place we used DelegatingPasswordEncoder
        // Default BCrypt PasswordEncode, But we used {noop} to tell spring that the password is not encrypted.
        return provider;
    }

    @Bean(name = "encoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/register", "/login")
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
   }



}