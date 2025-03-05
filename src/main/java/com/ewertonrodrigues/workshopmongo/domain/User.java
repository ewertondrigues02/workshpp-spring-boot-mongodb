package com.ewertonrodrigues.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa um usuário no sistema.
 * Cada usuário possui um identificador, nome, email e pode ter uma lista de posts associados.
 *
 * Esta classe é armazenada em um banco de dados MongoDB.
 */
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador único do usuário */
	@Id
	private String id;

	/** Nome do usuário */
	private String name;

	/** Email do usuário */
	private String email;

	/** Lista de postagens feitas pelo usuário */
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();

	/**
	 * Construtor padrão sem argumentos.
	 */
	public User() {
	}

	/**
	 * Construtor que inicializa um usuário com os dados fornecidos.
	 *
	 * @param id    Identificador do usuário
	 * @param name  Nome do usuário
	 * @param email Email do usuário
	 */
	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	/** @return O identificador do usuário */
	public String getId() {
		return id;
	}

	/** @param id Define o identificador do usuário */
	public void setId(String id) {
		this.id = id;
	}

	/** @return O nome do usuário */
	public String getName() {
		return name;
	}

	/** @param name Define o nome do usuário */
	public void setName(String name) {
		this.name = name;
	}

	/** @return O email do usuário */
	public String getEmail() {
		return email;
	}

	/** @param email Define o email do usuário */
	public void setEmail(String email) {
		this.email = email;
	}

	/** @return Lista de postagens associadas ao usuário */
	public List<Post> getPosts() {
		return posts;
	}

	/** @param posts Define a lista de postagens do usuário */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
