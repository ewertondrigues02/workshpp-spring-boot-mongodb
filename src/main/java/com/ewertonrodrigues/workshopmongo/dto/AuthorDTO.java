package com.ewertonrodrigues.workshopmongo.dto;

import com.ewertonrodrigues.workshopmongo.domain.User;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) que representa um autor.
 * Este DTO é utilizado para transferir dados do autor de forma simplificada,
 * contendo apenas seu ID e nome.
 */
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do autor
     */
    private String id;

    /**
     * Nome do autor
     */
    private String name;

    /**
     * Construtor padrão sem argumentos.
     */
    public AuthorDTO() {
    }

    /**
     * Construtor que inicializa um AuthorDTO com os dados de um usuário.
     *
     * @param obj Objeto {@link User} do qual os dados serão extraídos.
     */
    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    /**
     * @return O identificador do autor
     */
    public String getId() {
        return id;
    }

    /**
     * @param id Define o identificador do autor
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return O nome do autor
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Define o nome do autor
     */
    public void setName(String name) {
        this.name = name;
    }
}
