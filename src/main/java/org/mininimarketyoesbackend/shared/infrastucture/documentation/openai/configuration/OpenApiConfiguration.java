package org.mininimarketyoesbackend.shared.infrastucture.documentation.openai.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenApiConfiguration  implements WebMvcConfigurer {
    @Bean
    public OpenAPI minimarketYOES(){
        return new OpenAPI()
                .info(new Info().title("Minimarket's Yoes API")
                        .description(
                                "Minimarket's  YOES Application REST API Documentation")
                        .version("v1.1.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Minimarket's Yoes Wiki Documentation")
                        .url("https://minimarkets-elegant-service.wiki.github.org/docs"));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
