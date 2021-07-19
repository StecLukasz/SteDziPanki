package com.example.SteDziPanki.config;

import com.example.SteDziPanki.repository.UserEntityRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserEntityRepository repository;

    public WebSecurityConfig(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("lukasz").password("lukasz").roles("LUKASZ")
                .and()
                .withUser("grzegorz").password("grzegorz").roles("GRZEGORZ")
                .and()
                .withUser("konrad").password("konrad").roles("KONRAD");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/login")
                .hasAnyAuthority("ROLE ADMIN")
                .antMatchers("/","/index")
                .permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .and()
                .logout()
                .logoutSuccessUrl("/index");
    }

}