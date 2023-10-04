package com.example.portfolio.config;

import com.example.portfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;  // Assuming you're using a relational database.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // disable CSRF for simplicity; understand the implications and consider enabling it in production.
                .authorizeRequests()
                .antMatchers("/users/register", "/login").permitAll()  // Allow access to registration and login pages.
                .antMatchers("/projects/**").authenticated()  // Securing project-related endpoints.
                // ... Add other matchers and permissions as needed.
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessURL("/projects")  // Redirect to projects page after successful login.
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)  // Using the custom user service to load user details.
                .passwordEncoder(passwordEncoder());  // Using BCrypt password encoder.
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
