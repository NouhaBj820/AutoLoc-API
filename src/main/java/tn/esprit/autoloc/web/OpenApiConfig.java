package tn.esprit.autoloc.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "AutoLoc API",
                version = "1.0",
                description = "API de gestion de la location de véhicules"
        )
)
@Configuration
public class OpenApiConfig { }