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

## Get Started

### Banco de Dados

Criar banco de dados `example` no Postgres

> create database example

### Aplicação

> git clone https://github.com/giliard-ss/javaangular.git

> cd javaangular

> mvn clean package

> cd backend/target

> java -jar javaangular-1.0.0.jar

> http://localhost:8080/javaangular/#/login


## Compilação

> mvn clean package -P dev

Se preferir compilar um `.war` , alterar o atributo `packaging` de jar para war no arquivo pom da pasta backend . 

O projeto frontend possui um arquivo pom com todos os scripts para compilação dos arquivos em angular.
Os arquivos compilados ficarão em frontend/dist e a compilação do backend busca e copia esses arquivos para o jar/war.

## Angular

Para inicializar o frontend individualmente, executar o comando abaixo dentro da pasta frontend:

> npm start

### AppMaterialModule

O módulo abaixo reúne todos os módulos de componentes visuais do Material UI utilizados na aplicação. Basta apenas importar esse módulo nos novos módulos para reaproveitar.

> shared/app-material/app-material.module.ts

## Inicializar aplicação pela IDE

Executar o método main da classe MainApplication.java

## Contexto de Aplicação

Atualmente está configurado para o contexto /javaangular. A alteração deve ser realizada nos arquivos abaixo

> proxy.conf.js => target: http://localhost:8080/ **javaangular**

> package.json => build-prod: "ng build --configuration production --base-href /**javaangular**/",

> application.properties