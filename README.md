# Read Me First

The following was discovered as part of building this project:

* The JVM level was changed from '1.8' to '17', review
  the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range)
  on the wiki for more details.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Initialize
Para inicializar o frontend:
> npm start

Para realizar o deploy do war + angular, executar o pom.xml raiz
> mvn clean package 

O projeto frontend possui um arquivo pom que já tem todos os scripts para compilar o projeto angular.
Os arquivos compilados em angular ficarão em frontend/dist e a compilação do backend vai buscar e copiar esses arquivos para o war.

### Inicializar o war sem servidor de aplicação
Para inicializar diretamente , é preciso alterar o pom.xml do backend, de war para jar. Após isso é só executar o comando abaixo para executar o jar.
>java -jar project.jar