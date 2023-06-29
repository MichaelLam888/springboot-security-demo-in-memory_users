/*
 * @Author: Michael Lam 
 * @Date: 2023-06-29 15:23:48
 * @LastEditTime: 2023-06-29 15:42:01
 * @Description: 
 */
package dev.michaellam.springbootsecuritydemojavaguides.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();

  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService(){
    UserDetails michael = User.builder()
    .username("michael")
    .password(passwordEncoder().encode("michael"))
    .roles("USER")
    .build();

     UserDetails admin = User.builder()
    .username("admin")
    .password(passwordEncoder().encode("admin"))
    .roles("ADMIN")
    .build();
    return new InMemoryUserDetailsManager(michael,admin);

  }

}
