# VUTTR - Very Useful Tools to Remember

API 

## Ferramentas Utilizadas

* [Spring Tools Suite 4](https://spring.io/tools)

* [Gradle](https://maven.apache.org/download.cgi)

* [PostgreSQL](https://www.postgresql.org)

## Dependências

* Spring Web
* SpringBoot DevTools
* Spring Security
* Thymeleaf
* PostgreSQL
* JWT
* Lombok
* Dotenv
* JUnit
* Mockito

## Passos para executar o projeto

Criar o banco de dados no PostgreSQL

Criar a variável de ambiente DATASOURCE_URL. O projeto já encontra-se configurado para realizar a leitura de um arquivo .env

> DATASOURCE_URL=jdbc:[dialect]://[host]:[port]/[dbname]?user=[username]&password=[password]

Comando para build e execução

> ./gradlew bootRun

