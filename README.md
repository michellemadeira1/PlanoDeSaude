# Aplicação de Gerenciamento de Beneficiários e Documentos

## Descrição

Esta aplicação é uma API RESTful para gerenciar beneficiários e documentos. Desenvolvida com Java e Spring Boot, ela utiliza JPA para a persistência de dados. A documentação da API é gerada automaticamente com Swagger, garantindo uma fácil integração e uso por desenvolvedores.

## Estrutura do Projeto

- `controller`: Contém os controladores REST que expõem os endpoints da API.
- `model`: Contém as classes de entidade JPA.
- `repository`: Contém os repositórios JPA para interagir com o banco de dados.
- `service`: Contém a lógica de negócio.
- `exceptions`: Contém classes de exceções personalizadas.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Swagger com Springdoc OpenAPI
- Banco de dados H2

## Configuração

- `clone o repositório`:  Git clone <URL_DO_Repositorio>
- `navegue até o diretório do projeto`: Cd <NOME_DO_PROJETO>
- `Compile e construa o projeto`:
  - Maven:
      ```bash
     mvm install packge
      ```
  
- Execução
  - Para executar a aplicação, use o comando:
    - Maven:
  ```bash
  mvn spring-boot:run

## Executando a Aplicação

- Configure o banco de dados no arquivo `application.properties`:

   - spring.datasource.url=jdbc:h2:mem:testdb
   - spring.datasource.username=sa
   - spring.datasource.password=
   - pring.h2.console.enabled=true
   - spring.h2.console.path=/h2-console
   - spring.jpa.show-sql=true
   - spring.jpa.properties.hibernate.format_sql=true
   - spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

- Compile e execute a aplicação:
   - ./mvnw spring-boot:run

## Documentação da API

- A documentação da API está disponível em: http://localhost:8080/swagger-ui/index.html

## Documentação dos Endpoint

## ->  Beneficiários

- **Cadastrar Beneficiário**
  - **Método:** POST
  - **Endpoint:** `/api/beneficiarios`
  - **Request Body:** `Beneficiario` (Objeto que representa um beneficiário)

- **Listar Todos os Beneficiários**
  - **Método:** GET
  - **Endpoint:** `/api/beneficiarios/todos`
  - **Response:** `List<Beneficiario>` (Lista de todos os beneficiários)

- **Obter Beneficiário por ID**
  - **Método:** GET
  - **Endpoint:** `/api/beneficiarios/{id}`
  - **Path Variable:** `id` (ID do beneficiário)
  - **Response:** `Beneficiario` (Detalhes do beneficiário)

- **Obter Beneficiários por Nome**
  - **Método:** GET
  - **Endpoint:** `/api/beneficiarios/nome/{nome}`
  - **Path Variable:** `nome` (Nome do beneficiário)
  - **Response:** `List<Beneficiario>` (Lista de beneficiários com o nome fornecido)

- **Atualizar Beneficiário**
  - **Método:** PUT
  - **Endpoint:** `/api/beneficiarios/{id}`
  - **Path Variable:** `id` (ID do beneficiário a ser atualizado)
  - **Request Body:** `Beneficiario` (Objeto que representa o beneficiário atualizado)

- **Remover Beneficiário**
  - **Método:** DELETE
  - **Endpoint:** `/api/beneficiarios/{id}`
  - **Path Variable:** `id` (ID do beneficiário a ser removido)

## ->  Documentos

- **Cadastrar Documento**
  - **Método:** POST
  - **Endpoint:** `/api/documentos`
  - **Request Body:** `Documento` (Objeto que representa um documento)

- **Listar Todos os Documentos**
  - **Método:** GET
  - **Endpoint:** `/api/documentos/todos`
  - **Response:** `List<DocumentoDto>` (Lista de todos os documentos)

- **Obter Documento por ID**
  - **Método:** GET
  - **Endpoint:** `/api/documentos/{id}`
  - **Path Variable:** `id` (ID do documento)
  - **Response:** `Documento` (Detalhes do documento)

- **Obter Documentos por Beneficiário ID**
  - **Método:** GET
  - **Endpoint:** `/api/documentos/beneficiario/{beneficiarioId}`
  - **Path Variable:** `beneficiarioId` (ID do beneficiário)
  - **Response:** `List<Documento>` (Lista de documentos associados ao beneficiário)

- **Obter Documentos por Tipo**
  - **Método:** GET
  - **Endpoint:** `/api/documentos/tipo/{tipoDocumento}`
  - **Path Variable:** `tipoDocumento` (Tipo do documento)
  - **Response:** `List<Documento>` (Lista de documentos com o tipo especificado)

- **Atualizar Documento**
  - **Método:** PUT
  - **Endpoint:** `/api/documentos/{id}`
  - **Path Variable:** `id` (ID do documento a ser atualizado)
  - **Request Body:** `Documento` (Objeto que representa o documento atualizado)

- **Remover Documento**
  - **Método:** DELETE
  - **Endpoint:** `/api/documentos/{id}`
  - **Path Variable:** `id` (ID do documento a ser removido)


## Dependências

As principais dependências do projeto incluem:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>



