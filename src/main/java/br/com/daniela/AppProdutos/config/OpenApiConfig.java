package br.com.daniela.AppProdutos.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

public class OpenApiConfig {

  //aqui eu configuro para adicionar o Swagger

  @Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info()
						.title("App Cadastro de produtos")
						.description("Este aplicativo faz controle de cadastro de produtos")
						.contact(new Contact().name("Nome").email("email").url("url"))
						.version("Versão 0.0.1-SNAPSHOT"));//aqui pego a versão do pom xml
	}
  
}
