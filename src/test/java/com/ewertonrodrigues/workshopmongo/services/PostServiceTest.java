package com.ewertonrodrigues.workshopmongo.services;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import com.ewertonrodrigues.workshopmongo.repository.PostRepository;
import com.ewertonrodrigues.workshopmongo.services.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Testes unitários para a classe {@link PostService}.
 * Estes testes garantem que o serviço de posts está funcionando conforme esperado.
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository repo;

    @InjectMocks
    private PostService service;

    private Post post;
    private Date minDate;
    private Date maxDate;

    /**
     * Configuração inicial antes de cada teste.
     * Cria um post e define as datas mínimas e máximas para os testes.
     *
     * @throws Exception Se ocorrer algum erro durante a configuração.
     */
    @BeforeEach
    void setUp() {
        post = new Post("1", new Date(), "Title", "Content", null);
        minDate = new Date();
        maxDate = new Date();
    }

    /**
     * Testa o método {@link PostService#findById(String)} para o caso em que o post é encontrado.
     * <p>
     * Cenário:
     * - O repositório retorna um post válido.
     * - O método {@link PostService#findById(String)} deve retornar o post com os dados corretos.
     * <p>
     * Resultado esperado:
     * - O post retornado não deve ser nulo.
     * - O título do post deve ser igual ao esperado.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void testFindById_Success() {
        when(repo.findById("1")).thenReturn(Optional.of(post));

        Post foundPost = service.findById("1");

        assertNotNull(foundPost);
        assertEquals("Title", foundPost.getTitle());
    }

    /**
     * Testa o método {@link PostService#findById(String)} para o caso em que o post não é encontrado.
     * <p>
     * Cenário:
     * - O repositório não retorna um post válido.
     * - O método {@link PostService#findById(String)} deve lançar uma exceção {@link ObjectNotFoundException}.
     * <p>
     * Resultado esperado:
     * - O método deve lançar a exceção {@link ObjectNotFoundException}.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void testFindById_NotFound() {
        when(repo.findById("1")).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> service.findById("1"));
    }

    /**
     * Testa o método {@link PostService#findByTitle(String)}.
     * <p>
     * Cenário:
     * - O repositório retorna uma lista de posts que correspondem ao título fornecido.
     * - O método {@link PostService#findByTitle(String)} deve retornar os posts corretos.
     * <p>
     * Resultado esperado:
     * - A lista de posts não deve estar vazia.
     * - O número de posts deve ser igual a 1.
     * - O post retornado deve ser o mesmo que o post mockado.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void testFindByTitle() {
        when(repo.searchTitle("Title")).thenReturn(Arrays.asList(post));

        List<Post> posts = service.findByTitle("Title");

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
        assertEquals(post, posts.get(0));
    }

    /**
     * Testa o método {@link PostService#fullSearch(String, Date, Date)}.
     * <p>
     * Cenário:
     * - O repositório retorna uma lista de posts que correspondem aos parâmetros de busca.
     * - O método {@link PostService#fullSearch(String, Date, Date)} deve retornar os posts corretos.
     * <p>
     * Resultado esperado:
     * - A lista de posts não deve estar vazia.
     * - O número de posts deve ser igual a 1.
     * - O post retornado deve ser o mesmo que o post mockado.
     *
     * @throws Exception Se ocorrer algum erro durante o teste.
     */
    @Test
    void testFullSearch() {
        when(repo.fullSearch(anyString(), any(Date.class), any(Date.class))).thenReturn(Arrays.asList(post));

        List<Post> posts = service.fullSearch("Title", minDate, maxDate);

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
        assertEquals(post, posts.get(0));
    }
}
