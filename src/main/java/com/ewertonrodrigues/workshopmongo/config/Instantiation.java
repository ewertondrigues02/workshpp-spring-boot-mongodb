package com.ewertonrodrigues.workshopmongo.config;

import com.ewertonrodrigues.workshopmongo.domain.Post;
import com.ewertonrodrigues.workshopmongo.domain.User;
import com.ewertonrodrigues.workshopmongo.dto.AuthorDTO;
import com.ewertonrodrigues.workshopmongo.dto.CommentDTO;
import com.ewertonrodrigues.workshopmongo.repository.PostRepository;
import com.ewertonrodrigues.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * Classe de configuração para inicialização do banco de dados.
 * Implementa a interface {@link CommandLineRunner} para rodar um código ao iniciar a aplicação.
 * Utilizada para preencher o banco com dados iniciais.
 */
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    /**
     * Método que é executado ao iniciar a aplicação, responsável por popular o banco de dados com dados iniciais.
     * Este método realiza as seguintes operações:
     * <ul>
     *     <li>Deleta todos os dados anteriores das coleções de usuários e posts;</li>
     *     <li>Cria novos usuários e os salva no banco de dados;</li>
     *     <li>Cria novos posts e os associa aos usuários;</li>
     *     <li>Cria comentários para os posts e os associa corretamente;</li>
     *     <li>Atualiza o usuário com os posts criados.</li>
     * </ul>
     *
     * @param args Argumentos passados para a aplicação (não utilizados neste caso).
     * @throws Exception Se ocorrer algum erro durante a execução do método.
     */
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Deleta todos os usuários e posts existentes
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Criação de usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User cris = new User(null, "Cris Sudan", "cris@gmail.com");

        // Salva os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(maria, alex, cris));

        // Criação de posts
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feliz hoje!", new AuthorDTO(maria));

        // Criação de comentários
        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(cris));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        // Adiciona os comentários aos posts
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        // Salva os posts no banco de dados
        postRepository.saveAll(Arrays.asList(post1, post2));

        // Associa os posts ao usuário Maria
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
