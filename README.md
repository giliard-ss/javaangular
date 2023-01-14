# JAVA + Angular + Postgres

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
* Parametrização por profiles (dev/prod)
* Consumo API Rest
* CRUD utilizando Hibernate + Postgres

## Banco de dados

Necessário criar a database `example` para rodar o projeto.

> create database example;

## Compilação

Para compilar o war + angular, executar comando abaixo no diretório raiz

> mvn clean package -P dev

O projeto frontend possui um arquivo pom que já tem todos os scripts para compilação do projeto angular.
Os arquivos compilados em angular ficarão em frontend/dist e a compilação do backend busca e copia esses arquivos para o war.

## Angular
Para inicializar o frontend individualmente, executar o comando abaixo dentro da pasta frontend:
> npm start

### AppMaterialModule
O módulo abaixo reúne todos os módulos de componentes visuais do Material UI utilizados na aplicação. Basta apenas importar esse módulo nos novos módulos para reaproveitar.

> shared/app-material/app-material.module.ts

## Inicializar o war por linha de comando
Para inicializar diretamente é preciso compilar o projeto como `jar` e executar o comando abaixo
>java -jar javaangular.jar

Se for pela IDE basta executar o método main diretamente.

## Contexto de Aplicação

Atualmente está configurado para o contexto /javaangular. A alteração deve ser realizada nos arquivos abaixo

> proxy.conf.js => target: http://localhost:8080/ **javaangular**

> package.json => build-prod: "ng build --configuration production --base-href /**javaangular**/",

> application.properties