package it.cineca.springbootbeginner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("user")
	      .password(bCryptPasswordEncoder.encode("password"))
	      .roles("USER")
	      .build());
	    manager.createUser(User.withUsername("admin")
	      .password(bCryptPasswordEncoder.encode("secret"))
	      .roles("ADMIN")
	      .build());
	    return manager;
	}
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
          .disable()
          .authorizeRequests()
          .antMatchers(HttpMethod.GET)
          .hasAnyRole("ADMIN", "USER")
          .antMatchers("/box/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();

        return http.build();
    }
	
}
