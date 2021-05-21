package br.com.zupacademy.mario.casadocodigo.domain.Autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;

	@NotBlank(message = "O email não pode ser vazio")
	@Email(message = "O email deve ser válido")
	private String email;

	@NotBlank(message = "A descricao não pode ser vazia")
	@Length(max = 400, message = "A descricao deve ter no máximo 400 caracteres")
	private String descricao;

	@NotNull
	private LocalDateTime instante;

	@Deprecated
	public Autor() {
	}

	public Autor(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Length(max = 400) @NotEmpty String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instante = LocalDateTime.now();
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
}
