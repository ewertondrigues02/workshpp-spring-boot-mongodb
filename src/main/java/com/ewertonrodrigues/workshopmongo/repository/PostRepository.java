package com.ewertonrodrigues.workshopmongo.repository;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repositório para a entidade {@link Post}, responsável pelo acesso aos dados no MongoDB.
 * Estende {@link MongoRepository} para fornecer operações CRUD padrão.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    /**
     * Busca posts cujo título contenha o texto informado, ignorando maiúsculas e minúsculas.
     *
     * @param text Texto a ser pesquisado no título.
     * @return Lista de posts que contêm o texto no título.
     */
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String text);

    /**
     * Realiza uma busca completa por posts que satisfaçam as seguintes condições:
     * <ul>
     *   <li>Data do post dentro do intervalo especificado (minDate a maxDate).</li>
     *   <li>Texto pesquisado presente no título, corpo ou nos comentários do post.</li>
     * </ul>
     * A pesquisa ignora maiúsculas e minúsculas.
     *
     * @param text    Texto a ser pesquisado.
     * @param minDate Data mínima do post.
     * @param maxDate Data máxima do post.
     * @return Lista de posts que atendem aos critérios da pesquisa.
     */
    @Query("{$and: [ {date:{$gte: ?1} }, {date: { $lte: ?2} }, "
            + "{$or: [ {'title':{$regex: ?0, $options: 'i'} }, "
            + "{'body': {$regex: ?0, $options: 'i'} }, "
            + "{'comments.text': {$regex: ?0, $options: 'i'}}]}]}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    /**
     * Busca posts cujo título contenha o texto informado, ignorando maiúsculas e minúsculas.
     * Essa é uma alternativa usando um método de convenção do Spring Data.
     *
     * @param text Texto a ser pesquisado no título.
     * @return Lista de posts que contêm o texto no título.
     */
    List<Post> findByTitleContainingIgnoreCase(String text);
}
