package com.ewertonrodrigues.workshopmongo.services;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import com.ewertonrodrigues.workshopmongo.repository.PostRepository;
import com.ewertonrodrigues.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Serviço responsável por fornecer as operações de negócios para a entidade {@link Post}.
 * Utiliza o repositório {@link PostRepository} para acessar os dados no banco de dados MongoDB.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    /**
     * Busca um post pelo seu ID.
     *
     * @param id O ID do post a ser buscado.
     * @return O objeto {@link Post} correspondente ao ID informado.
     * @throws ObjectNotFoundException Se o post não for encontrado.
     */
    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    /**
     * Busca posts cujo título contenha o texto informado.
     *
     * @param text O texto a ser pesquisado no título dos posts.
     * @return Uma lista de objetos {@link Post} cujos títulos contêm o texto informado.
     */
    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    /**
     * Realiza uma busca completa por posts que satisfaçam as condições especificadas:
     * <ul>
     *   <li>A data do post deve estar dentro do intervalo fornecido (minDate a maxDate).</li>
     *   <li>O texto pesquisado deve estar presente no título, corpo ou nos comentários do post.</li>
     * </ul>
     *
     * @param text    O texto a ser pesquisado nos posts.
     * @param minDate A data mínima do post (início do intervalo de busca).
     * @param maxDate A data máxima do post (fim do intervalo de busca).
     * @return Uma lista de objetos {@link Post} que atendem aos critérios de pesquisa.
     */
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        // Ajusta a data máxima para incluir o final do dia.
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
