package com.renderbox.renderboxporoject.config;

import com.renderbox.renderboxporoject.service.CustomUserDetailsService;
import com.renderbox.renderboxporoject.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
//
//    @Autowired
//    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
//        this.jwtRequestFilter = jwtRequestFilter;
//    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                                .failureUrl("/login-error")
                )
                .logout(logout -> logout.logoutSuccessUrl("/login"))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(mvcMatcherBuilder.pattern("/public/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/private/**")).authenticated()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/api/chat/sendToken")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/api/messages/sendWithChatToken")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/api/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/api/**")).authenticated()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.PUT, "/api/**")).authenticated()
                                .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.DELETE, "/api/**")).authenticated()
                                .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/dashboard/**")).authenticated()
                                .requestMatchers(mvcMatcherBuilder.pattern("/api/authenticate/**")).permitAll()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                .userDetailsService(customUserDetailsService)
                .userDetailsService(userDetailsService)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}


