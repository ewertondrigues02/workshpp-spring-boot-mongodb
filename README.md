# Workshpop Springboot MongoDB

## Projeto: API REST Full de Gerenciamento de Usuários

**Descrição:**
Este projeto consiste em uma API RESTful desenvolvida em Java com o framework Spring Boot para fornecer operações CRUD (Create, Read, Update, Delete) para o gerenciamento de usuários. A aplicação utiliza o MongoDB como banco de dados NoSQL para armazenar os dados dos usuários.

**Recursos da API:**

**Listar Usuários:** Endpoint para listar todos os usuários cadastrados.
Obter Usuário por ID: Endpoint para recuperar os detalhes de um usuário específico com base no ID.
Adicionar Usuário: Endpoint para adicionar um novo usuário ao banco de dados.
Atualizar Usuário: Endpoint para atualizar as informações de um usuário existente com base no ID.
Excluir Usuário: Endpoint para excluir um usuário existente com base no ID.
Tecnologias Utilizadas:

**Spring Boot:** Framework Java para criação de aplicativos web e APIs RESTful.
MongoDB: Banco de dados NoSQL utilizado para armazenar os dados dos usuários de forma flexível e escalável.
Spring Data MongoDB: Módulo do Spring que facilita a integração entre o Spring Boot e o MongoDB, simplificando as operações de acesso aos dados.
Maven: Gerenciador de dependências para o projeto Java.
Postman: Ferramenta para testar e validar as chamadas da API durante o desenvolvimento.
Benefícios:

**Escalabilidade:** O uso do MongoDB permite escalar facilmente o banco de dados à medida que o número de usuários aumenta.
**Flexibilidade:** O MongoDB oferece flexibilidade na modelagem de dados, permitindo que diferentes tipos de informações de usuários sejam armazenadas de forma eficiente.
**Desenvolvimento Rápido:** O Spring Boot simplifica o desenvolvimento de APIs RESTful, permitindo que os desenvolvedores se concentrem na lógica de negócios em vez de configurar a infraestrutura.
Com este projeto, os desenvolvedores podem criar uma API RESTful completa para o gerenciamento de usuários de forma eficiente e escalável usando Spring Boot e MongoDB.


        
# **Relatório de Estrutura do Projeto Workshopmongo**

O projeto Workshopmongo é uma aplicação Java que utiliza o MongoDB para armazenar e manipular dados relacionados a usuários e posts. Abaixo está uma visão geral da estrutura do projeto, destacando os principais pacotes, classes e suas funcionalidades.


**Pacotes e Classes Principais:**

1. **com.ewertonrodrigues.workshopmongo**

   - **WorkshopmongoApplication.java:** Classe principal do projeto que inicia a aplicação Spring Boot.
  
2. **com.ewertonrodrigues.workshopmongo.config**

   - **Instantiation.java:** Classe responsável por realizar a inicialização dos dados no MongoDB ao iniciar a aplicação.

3. **com.ewertonrodrigues.workshopmongo.domain**

   - **Post.java:** Classe de entidade que representa um post no sistema.
   - **User.java:** Classe de entidade que representa um usuário no sistema.

4. **com.ewertonrodrigues.workshopmongo.dto**

   - **AuthorDTO.java:** Data Transfer Object (DTO) que encapsula informações básicas do autor de um post.
   - **CommentDTO.java:** DTO que encapsula informações de um comentário em um post.
   - **UserDTO.java:** DTO que encapsula informações de um usuário.

5. **com.ewertonrodrigues.workshopmongo.repository**

   - **PostRepository.java:** Interface que define operações de acesso a dados para a entidade Post.
   - **UserRepository.java:** Interface que define operações de acesso a dados para a entidade User.

6. **com.ewertonrodrigues.workshopmongo.resources**

   - **PostResource.java:** Classe controladora REST que define endpoints para manipulação de posts.
   - **UserResource.java:** Classe controladora REST que define endpoints para manipulação de usuários.

7. **com.ewertonrodrigues.workshopmongo.resources.exception**

   - **ResourceExceptionHandler.java:** Classe responsável por manipular exceções e retornar respostas adequadas para o cliente.
   - **StandardError.java:** Classe que representa um erro padrão a ser retornado em caso de exceção.

8. **com.ewertonrodrigues.workshopmongo.resources.util**

   - **URL.java:** Classe utilitária para manipulação de URLs.

9. **com.ewertonrodrigues.workshopmongo.services**

   - **PostService.java:** Classe de serviço que define operações relacionadas a posts.
   - **UserService.java:** Classe de serviço que define operações relacionadas a usuários.

10. **com.ewertonrodrigues.workshopmongo.services.exception**

    - **ObjectNotFoundException.java:** Exceção personalizada lançada quando um objeto não é encontrado no sistema.



Este relatório fornece uma visão geral da estrutura do projeto Workshopmongo, destacando os principais pacotes, classes e suas funcionalidades. Cada pacote e classe desempenha um papel importante na implementação e funcionamento da aplicação.

## Veja o Diagrama de Camadas:


![diagrama de camadas](https://github.com/ewertondrigues02/workshpp-spring-boot-mongodb/assets/106437473/4e7fdb76-6dce-4031-8235-3cfe92fd5f0f)



## Diagrama Conceitual:


![diagrama de projeto](https://github.com/ewertondrigues02/workshpp-spring-boot-mongodb/assets/106437473/32affb68-3a2a-4c81-8d1e-3b4fdb847b0d)












