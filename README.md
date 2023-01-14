# JAVA 8 + Angular + Postgres

* Java 1.8
* Spring Boot Starter Web 2.7.7
* Postgres 14
* Hibernate JPA
* Lombok
* Angular 15.0.4
* Node v18.12.1
* NPM 9.1.2
* Maven 3.8.1

## Implementações

* Controle de acesso
* Parametrização por profiles (dev, prod)
* Consumo API Rest

## Banco de dados

Executar o prompt e então executar os comandos abaixo para criar o banco de dados de exemplo ou utilizar o PgAdmin.

Conectar no banco com usuário postgres
> psql -U postgres;

Criar tabela example
> create database example;

### Produção

Altamente recomendável retirar a propriedade abaixo no arquivo application.properties quando for o ambiente de produção, pois o DBA que deve atender as alterações necessárias de banco.

> spring.jpa.hibernate.ddl-auto=update 

## Compilação

Para realizar o deploy do war + angular, executar o pom.xml raiz

> mvn clean package -P dev

O projeto frontend possui um arquivo pom que já tem todos os scripts para compilar o projeto angular.
Os arquivos compilados em angular ficarão em frontend/dist e a compilação do backend vai buscar e copiar esses arquivos para o war.

## Angular
Para inicializar o frontend individualmente, executar o comando abaixo dentro da pasta frontend:
> npm start

### AppMaterialModule
O módulo abaixo reúne todos os módulos de componentes visuais do angular utilizados na aplicação. Bastando apenas importar esse módulo manterá o código mais limpo.

> shared/app-material/app-material.module.ts

## Inicializar o war sem servidor de aplicação
Para inicializar diretamente , é preciso alterar o pom.xml do backend, de war para jar. Após isso é só executar o comando abaixo para executar o jar.
>java -jar project.jar

Se for pela IDE basta executar o método main para rodar o projeto com o server embutido no projeto.

## Contexto de Aplicação

Atualmente está configurado para o contexto /javaangular. A alteração deve ser realizada nos arquivos abaixo

> proxy.conf.js => target: http://localhost:8080/ **javaangular**

> package.json => build-prod: "ng build --configuration production --base-href /**javaangular**/",

> application.properties