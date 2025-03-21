package ru.janeryshouse.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                authorizeRequests ->
                        authorizeRequests.anyRequest()
                                .authenticated())
                .oauth2ResourceServer(
                        oAuth2ResourceServerConfigurer ->
                                oAuth2ResourceServerConfigurer.jwt(
                                        Customizer.withDefaults()))

                .build();
    }
}
