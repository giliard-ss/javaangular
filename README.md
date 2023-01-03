###Banco de dados

Executar o prompt e então executar os comandos abaixo para iniciar o banco de dados de exemplo:

> psql -U postgres;

> create database example;

As entidades serão criadas pelo hibernate.

### Angular
Para inicializar o frontend:
> npm start

Para realizar o deploy do war + angular, executar o pom.xml raiz
> mvn clean package 

O projeto frontend possui um arquivo pom que já tem todos os scripts para compilar o projeto angular.
Os arquivos compilados em angular ficarão em frontend/dist e a compilação do backend vai buscar e copiar esses arquivos para o war.

### Inicializar o war sem servidor de aplicação
Para inicializar diretamente , é preciso alterar o pom.xml do backend, de war para jar. Após isso é só executar o comando abaixo para executar o jar.
>java -jar project.jar

Se for pela IDE basta executar o método main para rodar o projeto com o server embutido no projeto.