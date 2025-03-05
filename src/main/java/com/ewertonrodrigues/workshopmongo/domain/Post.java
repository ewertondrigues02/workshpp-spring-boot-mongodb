package com.ewertonrodrigues.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ewertonrodrigues.workshopmongo.dto.AuthorDTO;
import com.ewertonrodrigues.workshopmongo.dto.CommentDTO;

/**
 * Representa uma postagem no sistema.
 * Cada post contém um título, um corpo de texto, um autor e comentários.
 *
 * Esta classe é armazenada em um banco de dados MongoDB.
 */
@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador único do post */
	@Id
	private String id;

	/** Data da postagem */
	private Date date;

	/** Título do post */
	private String title;

	/** Conteúdo principal do post */
	private String body;

	/** Autor da postagem */
	private AuthorDTO author;

	/** Lista de comentários associados ao post */
	private List<CommentDTO> comments = new ArrayList<>();

	/**
	 * Construtor padrão sem argumentos.
	 */
	public Post() {
	}

	/**
	 * Construtor que inicializa um post com os dados fornecidos.
	 *
	 * @param id     Identificador do post
	 * @param date   Data da postagem
	 * @param title  Título da postagem
	 * @param body   Conteúdo do post
	 * @param author Autor da postagem
	 */
	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	/** @return O identificador do post */
	public String getId() {
		return id;
	}

	/** @param id Define o identificador do post */
	public void setId(String id) {
		this.id = id;
	}

	/** @return A data do post */
	public Date getDate() {
		return date;
	}

	/** @param date Define a data do post */
	public void setDate(Date date) {
		this.date = date;
	}

	/** @return O título do post */
	public String getTitle() {
		return title;
	}

	/** @param title Define o título do post */
	public void setTitle(String title) {
		this.title = title;
	}

	/** @return O conteúdo do post */
	public String getBody() {
		return body;
	}

	/** @param body Define o conteúdo do post */
	public void setBody(String body) {
		this.body = body;
	}

	/** @return O autor do post */
	public AuthorDTO getAuthor() {
		return author;
	}

	/** @param author Define o autor do post */
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	/** @return Lista de comentários do post */
	public List<CommentDTO> getComments() {
		return comments;
	}

	/** @param comments Define a lista de comentários do post */
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
}
