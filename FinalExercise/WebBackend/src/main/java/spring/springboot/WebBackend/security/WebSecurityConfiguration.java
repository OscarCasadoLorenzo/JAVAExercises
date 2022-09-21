package spring.springboot.WebBackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/backweb/ticket").permitAll()
            .antMatchers(HttpMethod.GET, "/api/backweb/ticket/reserve/{destination}").permitAll()
            /*
            .antMatchers(HttpMethod.PUT).hasAnyAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.DELETE).hasAnyAuthority("ROLE_ADMIN")
            */
            .anyRequest().authenticated();

        return httpSecurity.build();
    }
}