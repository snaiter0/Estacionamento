package com.Estacionamento.Estacionamento.Configurations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//Esta classe é exclusiva para configurar o Swagger, sendo a ferramenta na qual faço os testes de requisições
// HTTP, consulto os modelos de cada Componente e suas condições.

@Configuration
public class SwaggerConfig {
	
@Bean
public Docket api() {
return new Docket(DocumentationType.SWAGGER_2)
.select()
.apis(RequestHandlerSelectors
.basePackage("com.Estacionamento.Estacionamento.Controller"))
.paths(PathSelectors.any())
.build()
.apiInfo(metadata())
.useDefaultResponseMessages(false)
.globalResponses(HttpMethod.GET, responseMessageForGET());
}

public static ApiInfo metadata() {
return new ApiInfoBuilder()
.title("API - Estacionamento")
.description("Projeto API Spring - Estacionamento")
.version("1.0.0")
.license("Apache License Version 2.0")
.licenseUrl("http://localhost:8080/swagger-ui/")
.contact(contact())
.build();
}

private static Contact contact() {
return new Contact("Douglas l. Souza",
"https://github.com/snaiter0",
"douglas.szlps@gmail.com");
}

private static List<Response> responseMessageForGET() {
return new ArrayList<Response>() {
private static final long serialVersionUID = 1L;
{
	
	// Aqui são respostas setadas manualmente, porém existe a opção default destas mensagens.
add(new ResponseBuilder().code("200")
.description("Sucesso!").build());
add(new ResponseBuilder().code("201")
.description("Objeto Criado!").build());
add(new ResponseBuilder().code("401")
.description("Não Autorizado!").build());
add(new ResponseBuilder().code("403")
.description("Proibido!").build());
add(new ResponseBuilder().code("404")
.description("Não Encontrado!").build());
add(new ResponseBuilder().code("500")
.description("Erro!").build());
}
};
}
}