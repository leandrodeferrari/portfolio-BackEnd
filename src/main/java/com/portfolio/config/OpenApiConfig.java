package com.portfolio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class OpenApiConfig {

    private final String name;
    private final String apiVersion;

    public OpenApiConfig (@Value("Portfolio") String name,
                          @Value("1.0.0") String apiVersion) {
        this.name = name;
        this.apiVersion = apiVersion;
    }

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "Bearer Authentication";
        final String apiTitle = String.format("%s API", StringUtils.capitalize(name));

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                            .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("Bearer")
                                                .bearerFormat("JWT")))
                .info(new Info()
                        .title(apiTitle)
                        .version(apiVersion)
                        .description("<strong>My Portfolio</strong> \uD83E\uDD73<br><br>" +
                                        "<a href=\"https://github.com/leandrodeferrari/portfolio-BackEnd\" target=_blank>GitHub Repository</a>")
                        .contact(new Contact()
                                .url("Coming soon")
                                .email("leandro_deferrari@hotmail.com")
                                .name("Leandro Deferrari")));

    }

}
