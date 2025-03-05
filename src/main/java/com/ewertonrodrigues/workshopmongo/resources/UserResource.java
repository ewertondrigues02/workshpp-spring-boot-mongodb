package com.ewertonrodrigues.workshopmongo.resources;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import com.ewertonrodrigues.workshopmongo.domain.User;
import com.ewertonrodrigues.workshopmongo.dto.UserDTO;
import com.ewertonrodrigues.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST responsável por gerenciar as requisições relacionadas aos usuários.
 * Contém métodos para buscar, criar, atualizar, excluir e listar posts associados a um usuário.
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    /**
     * Endpoint para buscar todos os usuários cadastrados.
     *
     * @return Uma lista de objetos {@link UserDTO} representando todos os usuários.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /**
     * Endpoint para buscar um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return O objeto {@link UserDTO} representando o usuário encontrado.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    /**
     * Endpoint para criar um novo usuário.
     *
     * @param objDTO O objeto {@link UserDTO} contendo as informações do usuário a ser criado.
     * @return A resposta contendo o URI do novo usuário criado.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * Endpoint para excluir um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     * @return Uma resposta sem conteúdo (204 No Content) após a exclusão.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint para atualizar as informações de um usuário pelo seu ID.
     *
     * @param objDTO O objeto {@link UserDTO} contendo as novas informações do usuário.
     * @param id     O ID do usuário a ser atualizado.
     * @return Uma resposta sem conteúdo (204 No Content) após a atualização.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
        User obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint para buscar todos os posts de um usuário específico.
     *
     * @param id O ID do usuário cujos posts serão buscados.
     * @return Uma lista de objetos {@link Post} representando os posts do usuário.
     */
    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}
