#JAVA + Angular + Postgres

* Java 1.8
* Spring Boot Starter Web 2.7.7
* Postgres 14
* Hibernate JPA
* Lombok
* Angular 15.0.4
* Node v18.12.1
* NPM 9.1.2
* Maven 3.8.1

###Banco de dados

Executar o prompt e ent�o executar os comandos abaixo para iniciar o banco de dados de exemplo:

> psql -U postgres;

> create database example;

As entidades ser�o criadas pelo hibernate.

### Angular
Para inicializar o frontend:
> npm start

Para realizar o deploy do war + angular, executar o pom.xml raiz
> mvn clean package 

O projeto frontend possui um arquivo pom que j� tem todos os scripts para compilar o projeto angular.
Os arquivos compilados em angular ficar�o em frontend/dist e a compila��o do backend vai buscar e copiar esses arquivos para o war.

### Inicializar o war sem servidor de aplica��o
Para inicializar diretamente , � preciso alterar o pom.xml do backend, de war para jar. Ap�s isso � s� executar o comando abaixo para executar o jar.
>java -jar project.jar

Se for pela IDE basta executar o m�todo main para rodar o projeto com o server embutido no projeto.