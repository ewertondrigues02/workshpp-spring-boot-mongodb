package com.ewertonrodrigues.workshopmongo.dto;

import com.ewertonrodrigues.workshopmongo.domain.User;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) que representa um usuário.
 * Esse DTO é utilizado para transferir dados do usuário sem expor diretamente a entidade User.
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do usuário
     */
    private String id;

    /**
     * Nome do usuário
     */
    private String name;

    /**
     * Email do usuário
     */
    private String email;

    /**
     * Construtor padrão sem argumentos.
     */
    public UserDTO() {
    }

    /**
     * Construtor que inicializa um UserDTO com os dados de um usuário.
     *
     * @param obj Objeto da entidade {@link User} do qual os dados serão extraídos.
     */
    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    /**
     * @return O identificador único do usuário
     */
    public String getId() {
        return id;
    }

    /**
     * @param id Define o identificador único do usuário
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return O nome do usuário
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Define o nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return O email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Define o email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
