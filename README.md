
### Initialize
Para inicializar o frontend:
> npm start

Para realizar o deploy do war + angular, executar o pom.xml raiz
> mvn clean package 

O projeto frontend possui um arquivo pom que j� tem todos os scripts para compilar o projeto angular.
Os arquivos compilados em angular ficar�o em frontend/dist e a compila��o do backend vai buscar e copiar esses arquivos para o war.

### Inicializar o war sem servidor de aplica��o
Para inicializar diretamente , � preciso alterar o pom.xml do backend, de war para jar. Ap�s isso � s� executar o comando abaixo para executar o jar.
>java -jar project.jar