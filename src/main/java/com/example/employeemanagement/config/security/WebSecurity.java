package com.example.employeemanagement.config.security;

import com.example.employeemanagement.entity.common.Constants;
import com.example.employeemanagement.exception.AuthExceptionHandler;
import com.example.employeemanagement.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final AccountService accountService;
    private final AuthExceptionHandler authExceptionHandler;


    public WebSecurity(AccountService accountService, AuthExceptionHandler authExceptionHandler) {
        this.accountService = accountService;
        this.authExceptionHandler = authExceptionHandler;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .exceptionHandling()
                    .accessDeniedHandler(authExceptionHandler)
                    .authenticationEntryPoint(authExceptionHandler)
                .and()
                .authorizeRequests()
                    .antMatchers("/api/v1/accounts").hasAnyAuthority(Constants.ROLE.ADMIN)
                    .antMatchers("api/v1/departments").hasAnyAuthority(Constants.ROLE.ADMIN)
                    .antMatchers(HttpMethod.GET,"api/v1/departments").hasAnyAuthority(Constants.ROLE.EMPLOYEE)
    //                .antMatchers("/api/v1/accounts/**")
    //                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}


