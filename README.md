# VUTTR - Very Useful Tools to Remember

API 

## Ferramentas Utilizadas

* [Spring Tools Suite 4](https://spring.io/tools)

* [Gradle](https://maven.apache.org/download.cgi)

* [PostgreSQL](https://www.postgresql.org)

## Java 11

## Dependências

* Spring Web
* SpringBoot DevTools
* Spring Security
* Spring Validation
* Spring Data JPA
* PostgreSQL
* JWT(jjwt)
* Lombok
* Dotenv
* JUnit
* Mockito


## Testes

> Os testes estão localizados em **src/test**

## Documentação

Local

> [http://localhost:3000/docs.html](http://localhost:3000/docs.html)


Heroku

> [https://vuttr-iury.herokuapp.com/docs.html](https://vuttr-iury.herokuapp.com/docs.html)


## Passos para executar o projeto

Criar um banco de dados no PostgreSQL(nome do banco a sua escolha)

Criar a variável de ambiente DATASOURCE_URL. O projeto já encontra-se configurado para realizar a leitura de um arquivo .env

```console
DATASOURCE_URL=jdbc:[dialect]://[host]:[port]/[dbname]?user=[username]&password=[password]
```

Comando para build e execução:

```console
./gradlew bootRun
```
