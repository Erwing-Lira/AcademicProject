package com.elira.academic.config;

import com.elira.academic.config.filter.JwtAuthenticationFilter;
import com.elira.academic.config.filter.JwtValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;

    public SecurityConfig(
            AuthenticationConfiguration authenticationConfiguration
    ) {
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(Customizer.withDefaults())
                .addFilter(
                        new JwtAuthenticationFilter(authenticationManager())
                )
                .addFilter(
                        new JwtValidationFilter(authenticationManager())
                )
                .authorizeHttpRequests( auth ->
                        auth
                                /* CREATE PROFESSOR AND STUDENT FOR DEV
                                .requestMatchers(HttpMethod.POST, "/api/professor").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/students").permitAll()*/

                                // ADMIN
                                .requestMatchers("/api/users/**").hasRole("ADMIN")
                                .requestMatchers("/api/professor/**").hasRole("ADMIN")
                                .requestMatchers("/api/students/**").hasRole("ADMIN")
                                .requestMatchers("/api/asignatures/**").hasRole("ADMIN")
                                .requestMatchers("/api/courses/**").hasRole("ADMIN")
                                .requestMatchers("/api/periods/**").hasRole("ADMIN")
                                .requestMatchers("/api/reports/**").hasRole("ADMIN")

                                // PROFESOR
                                .requestMatchers("/api/notes/**").hasRole("PROFESOR")
                                .requestMatchers("/api/materials/**").hasRole("PROFESOR")

                                // ESTUDIANTE
                                .requestMatchers("/api/notes/student/**").hasRole("ESTUDIANTE")
                                .requestMatchers("/api/materials/asignature/**").hasRole("ESTUDIANTE")


                                .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
