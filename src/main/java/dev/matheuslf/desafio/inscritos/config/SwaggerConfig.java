package dev.matheuslf.desafio.inscritos.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact()
                .name("Fabricio Passos")
                .url("https://github.com/Fabricio3916")
                .email("fabriciopassos3916@gmail.com");

        Info info = new Info()
                .title("Sistema de Gestão de Projetos")
                .version("v1")
                .description("""
                        API para gerenciamento de projetos e tarefas de uma empresa.
                        Autenticação via JWT e operações CRUD seguras para usuários e projetos.
                        """)
                .contact(contact)
                .license(new License()
                        .name("MIT License")
                        .url("https://opensource.org/licenses/MIT"));

        return new OpenAPI()
                .info(info)
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor Local")
                ));
    }
}
