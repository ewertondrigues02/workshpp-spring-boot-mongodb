package com.ewertonrodrigues.workshopmongo.services;

import com.ewertonrodrigues.workshopmongo.domain.User;
import com.ewertonrodrigues.workshopmongo.dto.UserDTO;
import com.ewertonrodrigues.workshopmongo.repository.UserRepository;
import com.ewertonrodrigues.workshopmongo.services.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Testes unitários para a classe {@link UserService}.
 * Esses testes garantem que o serviço de usuários está funcionando corretamente em diferentes cenários.
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserService service;

    private User user;

    /**
     * Configuração inicial antes de cada teste.
     * Cria um usuário mockado para ser utilizado nos testes.
     *
     * @throws Exception Se ocorrer algum erro durante a configuração.
     */
    @BeforeEach
    void setUp() {
        user = new User("1", "Ewerton Rodrigues", "ewerton@example.com");
    }

    /**
     * Testa o método {@link UserService#findAll()}.
     * Verifica se o método retorna uma lista de usuários não vazia.
     * <p>
     * Cenário:
     * - O repositório retorna uma lista com um usuário.
     * <p>
     * Resultado esperado:
     * - A lista de usuários não deve estar vazia.
     * - O nome do usuário na lista deve ser "Ewerton Rodrigues".
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void findAll_ShouldReturnUserList() {
        when(repo.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = service.findAll();

        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals("Ewerton Rodrigues", users.get(0).getName());
    }

    /**
     * Testa o método {@link UserService#findById(String)} quando o usuário existe.
     * Verifica se o método retorna o usuário correto.
     * <p>
     * Cenário:
     * - O repositório retorna um usuário com o ID "1".
     * <p>
     * Resultado esperado:
     * - O usuário encontrado deve ter o ID "1" e o nome "Ewerton Rodrigues".
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void findById_WhenUserExists_ShouldReturnUser() {
        when(repo.findById("1")).thenReturn(Optional.of(user));

        User foundUser = service.findById("1");

        assertNotNull(foundUser);
        assertEquals("1", foundUser.getId());
        assertEquals("Ewerton Rodrigues", foundUser.getName());
    }

    /**
     * Testa o método {@link UserService#findById(String)} quando o usuário não existe.
     * Verifica se o método lança a exceção {@link ObjectNotFoundException}.
     * <p>
     * Cenário:
     * - O repositório não retorna um usuário com o ID "2".
     * <p>
     * Resultado esperado:
     * - O método deve lançar uma exceção {@link ObjectNotFoundException}.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void findById_WhenUserDoesNotExist_ShouldThrowException() {
        when(repo.findById("2")).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> service.findById("2"));
    }

    /**
     * Testa o método {@link UserService#insert(User)}.
     * Verifica se o usuário é salvo corretamente.
     * <p>
     * Cenário:
     * - O repositório insere o usuário corretamente.
     * <p>
     * Resultado esperado:
     * - O usuário salvo deve ter o ID "1".
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void insert_ShouldSaveUser() {
        when(repo.insert(user)).thenReturn(user);

        User savedUser = service.insert(user);

        assertNotNull(savedUser);
        assertEquals("1", savedUser.getId());
    }

    /**
     * Testa o método {@link UserService#delete(String)} quando o usuário existe.
     * Verifica se o usuário é deletado corretamente.
     * <p>
     * Cenário:
     * - O repositório encontra um usuário com o ID "1".
     * <p>
     * Resultado esperado:
     * - O método {@link UserService#delete(String)} deve não lançar exceção.
     * - O método  deve ser chamado uma vez.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void delete_WhenUserExists_ShouldDeleteUser() {
        when(repo.findById("1")).thenReturn(Optional.of(user));
        doNothing().when(repo).deleteById("1");

        assertDoesNotThrow(() -> service.delete("1"));
        verify(repo, times(1)).deleteById("1");
    }

    /**
     * Testa o método {@link UserService#delete(String)} quando o usuário não existe.
     * Verifica se o método lança a exceção {@link ObjectNotFoundException}.
     * <p>
     * Cenário:
     * - O repositório não encontra um usuário com o ID "2".
     * <p>
     * Resultado esperado:
     * - O método deve lançar uma exceção {@link ObjectNotFoundException}.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void delete_WhenUserDoesNotExist_ShouldThrowException() {
        when(repo.findById("2")).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> service.delete("2"));
    }

    /**
     * Testa o método {@link UserService#update(User)} quando o usuário existe.
     * Verifica se o usuário é atualizado corretamente.
     * <p>
     * Cenário:
     * - O repositório encontra um usuário com o ID "1".
     * - O repositório salva o usuário atualizado corretamente.
     * <p>
     * Resultado esperado:
     * - O nome e o email do usuário atualizado devem ser "Updated Name" e "updated@example.com", respectivamente.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void update_WhenUserExists_ShouldUpdateUser() {
        User updatedUser = new User("1", "Updated Name", "updated@example.com");
        when(repo.findById("1")).thenReturn(Optional.of(user));
        when(repo.save(any(User.class))).thenReturn(updatedUser);

        User result = service.update(updatedUser);

        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
        assertEquals("updated@example.com", result.getEmail());
    }

    /**
     * Testa o método {@link UserService#update(User)} quando o usuário não existe.
     * Verifica se o método lança a exceção {@link ObjectNotFoundException}.
     * <p>
     * Cenário:
     * - O repositório não encontra um usuário com o ID "2".
     * <p>
     * Resultado esperado:
     * - O método deve lançar uma exceção {@link ObjectNotFoundException}.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void update_WhenUserDoesNotExist_ShouldThrowException() {
        User updatedUser = new User("2", "Updated Name", "updated@example.com");
        when(repo.findById("2")).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> service.update(updatedUser));
    }

    /**
     * Testa o método {@link UserService#fromDTO(UserDTO)}.
     * Verifica se o método converte corretamente um DTO em um objeto {@link User}.
     * <p>
     * Cenário:
     * - Um {@link UserDTO} é passado para conversão.
     * <p>
     * Resultado esperado:
     * - O usuário convertido não deve ser nulo.
     * - O ID, nome e email do usuário convertido devem ser iguais aos do DTO.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void fromDTO_ShouldConvertDTOToUser() {
        UserDTO dto = new UserDTO();
        User convertedUser = service.fromDTO(dto);

        assertNotNull(convertedUser);
        assertEquals(dto.getId(), convertedUser.getId());
        assertEquals(dto.getName(), convertedUser.getName());
        assertEquals(dto.getEmail(), convertedUser.getEmail());
    }
}
