package com.roua.roua.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/auth/register") // Set the appropriate mapping for your API
                        .allowedOrigins("http://localhost:4200") // Allow requests from your frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
                        .allowedHeaders("*") // Specify allowed headers
                        .allowCredentials(true); // Allow credentials (cookies, etc.)
            }
        };
    }
}