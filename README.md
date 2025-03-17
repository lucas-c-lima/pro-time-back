# Protime Backend

## Visão Geral

Este projeto é uma aplicação back-end para gerenciar atividades e usuários. Ele é construído usando Java, Spring Boot e Maven, e utiliza um banco de dados MySQL.

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6.0 ou superior
- MySQL 5.7 ou superior

## Instalação

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/lucas-c-lima/pro-time-back.git
    cd protime
    ```

2. **Configure o banco de dados:**

   Certifique-se de que você tem um servidor MySQL em execução e crie um banco de dados chamado `sistema_gerenciamento`. Você pode fazer isso usando a linha de comando do MySQL ou uma ferramenta como o phpMyAdmin.

    ```sql
    CREATE DATABASE sistema_gerenciamento;
    ```

3. **Atualize a configuração do banco de dados:**

   Abra o arquivo `src/main/resources/application.properties` e atualize as seguintes propriedades com suas credenciais do MySQL:

    ```ini
    spring.datasource.url=jdbc:mysql://localhost:3306/sistema_gerenciamento?createDatabaseIfNotExist=true
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    ```

4. **Construa o projeto:**

   Navegue até o diretório do projeto e execute o seguinte comando para construir o projeto usando Maven:

    ```bash
    mvn clean install
    ```

5. **Execute a aplicação:**

   Após construir o projeto, você pode executar a aplicação usando o seguinte comando:

    ```bash
    mvn spring-boot:run
    ```

## Configuração

A aplicação utiliza as seguintes propriedades de configuração, que podem ser encontradas no arquivo `src/main/resources/application.properties`:

- `spring.datasource.url`: A URL do banco de dados MySQL.
- `spring.datasource.username`: O nome de usuário para o banco de dados MySQL.
- `spring.datasource.password`: A senha para o banco de dados MySQL.
- `spring.jpa.hibernate.ddl-auto`: A estratégia para geração de schema (por exemplo, `update`).
- `spring.jpa.show-sql`: Se deve mostrar as instruções SQL no console.
- `spring.jpa.properties.hibernate.format_sql`: Se deve formatar as instruções SQL no console.
- `api.security.token.secret`: A chave secreta para geração de token JWT.

## Documentação Swagger

A aplicação inclui o Swagger para documentação da API. Uma vez que a aplicação esteja em execução, você pode acessar a interface do Swagger no seguinte URL:

http://localhost:8080/swagger-ui/index.html#/

Isso fornecerá uma interface web onde você pode explorar e testar os endpoints da API.

## Licença

Este projeto é licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.