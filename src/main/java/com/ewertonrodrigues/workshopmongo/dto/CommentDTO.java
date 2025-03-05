package com.ewertonrodrigues.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Data Transfer Object (DTO) que representa um comentário.
 * Este DTO é utilizado para encapsular os dados de um comentário associado a um post.
 */
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Conteúdo do comentário
     */
    private String text;

    /**
     * Data em que o comentário foi feito
     */
    private Date date;

    /**
     * Autor do comentário
     */
    private AuthorDTO author;

    /**
     * Construtor padrão sem argumentos.
     */
    public CommentDTO() {
    }

    /**
     * Construtor que inicializa um CommentDTO com os dados fornecidos.
     *
     * @param text   Conteúdo do comentário.
     * @param date   Data do comentário.
     * @param author Autor do comentário representado por {@link AuthorDTO}.
     */
    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    /**
     * @return O conteúdo do comentário
     */
    public String getText() {
        return text;
    }

    /**
     * @param text Define o conteúdo do comentário
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return A data do comentário
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date Define a data do comentário
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return O autor do comentário
     */
    public AuthorDTO getAuthor() {
        return author;
    }

    /**
     * @param author Define o autor do comentário
     */
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
