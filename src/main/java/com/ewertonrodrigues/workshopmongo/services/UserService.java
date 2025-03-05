package com.ewertonrodrigues.workshopmongo.services;

import com.ewertonrodrigues.workshopmongo.domain.User;
import com.ewertonrodrigues.workshopmongo.dto.UserDTO;
import com.ewertonrodrigues.workshopmongo.repository.UserRepository;
import com.ewertonrodrigues.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pelas operações de negócios para a entidade {@link User}.
 * Utiliza o repositório {@link UserRepository} para acessar os dados no banco de dados MongoDB.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    /**
     * Busca todos os usuários cadastrados no banco de dados.
     *
     * @return Uma lista de objetos {@link User} contendo todos os usuários encontrados.
     */
    public List<User> findAll() {
        return repo.findAll();
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return O objeto {@link User} correspondente ao ID informado.
     * @throws ObjectNotFoundException Se o usuário não for encontrado.
     */
    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    /**
     * Insere um novo usuário no banco de dados.
     *
     * @param obj O objeto {@link User} a ser inserido.
     * @return O objeto {@link User} inserido no banco de dados.
     */
    public User insert(User obj) {
        return repo.insert(obj);
    }

    /**
     * Deleta um usuário do banco de dados pelo seu ID.
     *
     * @param id O ID do usuário a ser deletado.
     * @throws ObjectNotFoundException Se o usuário não for encontrado.
     */
    public void delete(String id) {
        findById(id); // Verifica se o usuário existe antes de deletar.
        repo.deleteById(id);
    }

    /**
     * Atualiza os dados de um usuário no banco de dados.
     *
     * @param obj O objeto {@link User} com as novas informações.
     * @return O objeto {@link User} atualizado.
     * @throws ObjectNotFoundException Se o usuário não for encontrado.
     */
    public User update(User obj) {
        Optional<User> optionalUser = repo.findById(obj.getId());
        User newObj = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
        updateData(newObj, obj); // Atualiza os dados do usuário
        return repo.save(newObj);
    }

    /**
     * Atualiza os dados de um usuário com as informações de outro usuário.
     *
     * @param newObj O usuário a ser atualizado.
     * @param obj    O usuário com os novos dados.
     */
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    /**
     * Converte um objeto DTO {@link UserDTO} para um objeto de domínio {@link User}.
     *
     * @param objDTO O objeto DTO a ser convertido.
     * @return O objeto de domínio {@link User} correspondente.
     */
    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
