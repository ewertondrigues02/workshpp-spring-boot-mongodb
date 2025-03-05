package com.ewertonrodrigues.workshopmongo.resources;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import com.ewertonrodrigues.workshopmongo.resources.util.URL;
import com.ewertonrodrigues.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Controlador REST responsável por gerenciar as requisições relacionadas aos posts.
 * Contém métodos para buscar posts por ID, título e realizar buscas completas com filtros de data e texto.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    /**
     * Endpoint para buscar um post pelo seu ID.
     *
     * @param id O ID do post a ser buscado.
     * @return Um objeto {@link ResponseEntity} contendo o post encontrado ou um erro caso o post não seja encontrado.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Endpoint para buscar posts cujo título contenha o texto especificado.
     *
     * @param text O texto a ser pesquisado no título dos posts. O valor padrão é uma string vazia.
     * @return Uma lista de posts cujo título contém o texto informado.
     */
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Endpoint para realizar uma busca completa por posts com filtros de texto e intervalo de data.
     * A busca será realizada no título, corpo e comentários do post.
     *
     * @param text    O texto a ser pesquisado nos posts. O valor padrão é uma string vazia.
     * @param minDate A data mínima para o filtro de data. O valor padrão é a data 01/01/1970.
     * @param maxDate A data máxima para o filtro de data. O valor padrão é a data atual.
     * @return Uma lista de posts que atendem aos critérios de pesquisa especificados.
     */
    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
