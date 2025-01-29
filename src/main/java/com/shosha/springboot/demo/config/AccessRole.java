package com.shosha.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class to set up security roles and user details in the application.
 * This class defines an in-memory user details manager and a security filter chain
 * to manage authentication and authorization.
 */
@Configuration
public class AccessRole {

    /**
     * Configures an in-memory user details manager with predefined users and their roles.
     *
     * @return InMemoryUserDetailsManager containing users with roles.
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManagerConfigurer() {
        UserDetails mohamed = User.builder()
                .username("mohamed")
                .password("{bcrypt}$2b$12$7iAyE1cxV56JlSlhcSm4ze1JLlxfd/in8tc0W/t7xdeaKR7ZulutC")
                .roles("Employee", "Manager", "Admin")
                .build();

        UserDetails karim = User.builder()
                .username("karim")
                .password("{bcrypt}$2a$12$FaKD6z8mqO2M.oEFdhQ86e7bGpUnM7.E4qx/FjMpD2hkAP6SItjXi")
                .roles("Employee", "Manager")
                .build();

        UserDetails eslam = User.builder()
                .username("eslam")
                .password("{bcrypt}$2a$12$d6vINCihOUr.5l21lBntjOeNtR.YQyprCDGOl2/6DoYhVE4J3OSY6")
                .roles("Employee")
                .build();
        return new InMemoryUserDetailsManager(eslam, karim, mohamed);
    }

    /**
     * Configures the security filter chain for the application.
     * This method sets up request authorization, form login, logout, and exception handling.
     *
     * @param http the HttpSecurity object to configure.
     * @return SecurityFilterChain object with the configured settings.
     * @throws Exception if any configuration error occurs.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("Employee")
                                .requestMatchers("/instructors/new/**").hasRole("Manager")
                                .requestMatchers("/instructors/edit/**").hasRole("Manager")
                                .requestMatchers("/instructors/").hasRole("Admin")
                                .requestMatchers("/instructors/delete/**").hasRole("Admin")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)

                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/instructors/access-denied")

                );

        return http.build();
    }
}
