
---

# Workshop Spring Boot MongoDB

## Projeto: API RESTful de Gerenciamento de Usuários

Este projeto consiste em uma API RESTful desenvolvida em Java com o framework Spring Boot, utilizando MongoDB como banco de dados NoSQL. A API oferece operações CRUD (Create, Read, Update, Delete) para o gerenciamento de usuários e posts.

### Funcionalidades da API:

- **Listar Usuários**: Endpoint para listar todos os usuários cadastrados.
- **Obter Usuário por ID**: Endpoint para recuperar os detalhes de um usuário específico com base no ID.
- **Adicionar Usuário**: Endpoint para adicionar um novo usuário ao banco de dados.
- **Atualizar Usuário**: Endpoint para atualizar as informações de um usuário existente com base no ID.
- **Excluir Usuário**: Endpoint para excluir um usuário existente com base no ID.
- **Listar Posts**: Endpoint para listar todos os posts.
- **Adicionar Post**: Endpoint para adicionar um novo post.
- **Atualizar Post**: Endpoint para atualizar as informações de um post existente com base no ID.
- **Excluir Post**: Endpoint para excluir um post existente com base no ID.

---

### Tecnologias Utilizadas:

- **Spring Boot**: Framework Java para criação de aplicativos web e APIs RESTful.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenar os dados de usuários e posts de forma flexível e escalável.
- **Spring Data MongoDB**: Módulo do Spring que facilita a integração entre o Spring Boot e o MongoDB, simplificando as operações de acesso aos dados.
- **Maven**: Gerenciador de dependências para o projeto Java.
- **Postman**: Ferramenta para testar e validar as chamadas da API durante o desenvolvimento.

---

### Benefícios:

- **Escalabilidade**: O uso do MongoDB permite escalar facilmente o banco de dados à medida que o número de usuários aumenta.
- **Flexibilidade**: O MongoDB oferece flexibilidade na modelagem de dados, permitindo armazenar diferentes tipos de informações de usuários e posts de forma eficiente.
- **Desenvolvimento Rápido**: O Spring Boot simplifica o desenvolvimento de APIs RESTful, permitindo que os desenvolvedores se concentrem na lógica de negócios em vez de configurar a infraestrutura.

Com este projeto, os desenvolvedores podem criar uma API RESTful completa para o gerenciamento de usuários e posts de forma eficiente e escalável utilizando Spring Boot e MongoDB.

---

## Estrutura do Projeto

O projeto **Workshopmongo** é uma aplicação Java que utiliza o MongoDB para armazenar e manipular dados relacionados a usuários e posts. Abaixo está a descrição da estrutura do projeto, com ênfase nos pacotes, classes e suas funcionalidades.

### Pacotes e Classes Principais:

#### `com.ewertonrodrigues.workshopmongo`
- **WorkshopmongoApplication.java**: Classe principal do projeto que inicia a aplicação Spring Boot.

#### `com.ewertonrodrigues.workshopmongo.config`
- **Instantiation.java**: Classe responsável por realizar a inicialização dos dados no MongoDB ao iniciar a aplicação.

#### `com.ewertonrodrigues.workshopmongo.domain`
- **Post.java**: Classe de entidade que representa um post no sistema.
- **User.java**: Classe de entidade que representa um usuário no sistema.

#### `com.ewertonrodrigues.workshopmongo.dto`
- **AuthorDTO.java**: Data Transfer Object (DTO) que encapsula informações básicas do autor de um post.
- **CommentDTO.java**: DTO que encapsula informações de um comentário em um post.
- **UserDTO.java**: DTO que encapsula informações de um usuário.

#### `com.ewertonrodrigues.workshopmongo.repository`
- **PostRepository.java**: Interface que define operações de acesso a dados para a entidade Post.
- **UserRepository.java**: Interface que define operações de acesso a dados para a entidade User.

#### `com.ewertonrodrigues.workshopmongo.resources`
- **PostResource.java**: Classe controladora REST que define endpoints para manipulação de posts.
- **UserResource.java**: Classe controladora REST que define endpoints para manipulação de usuários.

#### `com.ewertonrodrigues.workshopmongo.resources.exception`
- **ResourceExceptionHandler.java**: Classe responsável por manipular exceções e retornar respostas adequadas para o cliente.
- **StandardError.java**: Classe que representa um erro padrão a ser retornado em caso de exceção.

#### `com.ewertonrodrigues.workshopmongo.resources.util`
- **URL.java**: Classe utilitária para manipulação de URLs.

#### `com.ewertonrodrigues.workshopmongo.services`
- **PostService.java**: Classe de serviço que define operações relacionadas a posts.
- **UserService.java**: Classe de serviço que define operações relacionadas a usuários.

#### `com.ewertonrodrigues.workshopmongo.services.exception`
- **ObjectNotFoundException.java**: Exceção personalizada lançada quando um objeto não é encontrado no sistema.

---

### Como Executar o Projeto:

1. **Clonar o repositório**:
    ```bash
    git clone https://github.com/ewertonrodrigues/workshopmongo.git
    cd workshopmongo
    ```

2. **Configurar o MongoDB**:
   - Certifique-se de ter o MongoDB instalado e em execução. Você pode iniciar o MongoDB localmente ou utilizar uma instância remota.
   - Altere as configurações de conexão no arquivo `application.properties` (se necessário).

3. **Compilar e Executar**:
   - Compile e execute o projeto com o Maven:
    ```bash
    mvn spring-boot:run
    ```

4. **Testar a API**:
   - Use o Postman para testar os endpoints da API. O Swagger UI também pode estar disponível dependendo da configuração, permitindo testar diretamente pela interface web.

---

### Exemplos de Endpoints:

- **GET /users**: Lista todos os usuários.
- **GET /users/{id}**: Recupera um usuário pelo ID.
- **POST /users**: Adiciona um novo usuário.
- **PUT /users/{id}**: Atualiza um usuário existente.
- **DELETE /users/{id}**: Exclui um usuário pelo ID.

- **GET /posts**: Lista todos os posts.
- **POST /posts**: Adiciona um novo post.
- **PUT /posts/{id}**: Atualiza um post existente.
- **DELETE /posts/{id}**: Exclui um post pelo ID.

---

### Contribuições

Sinta-se à vontade para contribuir com melhorias, sugestões ou correções! Você pode fazer isso através de pull requests.

---

### Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---



## Veja o Diagrama de Camadas:


![diagrama de camadas](https://github.com/ewertondrigues02/workshpp-spring-boot-mongodb/assets/106437473/4e7fdb76-6dce-4031-8235-3cfe92fd5f0f)



## Diagrama Conceitual:


![diagrama de projeto](https://github.com/ewertondrigues02/workshpp-spring-boot-mongodb/assets/106437473/32affb68-3a2a-4c81-8d1e-3b4fdb847b0d)












