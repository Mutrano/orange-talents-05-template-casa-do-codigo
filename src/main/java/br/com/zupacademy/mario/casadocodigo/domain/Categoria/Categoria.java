package br.com.zupacademy.mario.casadocodigo.domain.Categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "o nome nao pode ser vazio")
	private String nome;

	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
