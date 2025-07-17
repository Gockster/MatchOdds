package com.match.matchOdds.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI matchOddsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Match Odds API")
                        .description("REST API for managing sports matches and their odds")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Match Odds Team")
                                .email("support@matchodds.com")));
    }
}
