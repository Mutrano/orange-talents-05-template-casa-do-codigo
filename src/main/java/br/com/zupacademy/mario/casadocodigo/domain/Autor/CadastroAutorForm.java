package br.com.zupacademy.mario.casadocodigo.domain.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CadastroAutorForm {
	
	@NotBlank(message="O nome não pode ser vazio")
	private String nome;
	
	@NotBlank(message="O email não pode ser vazio")
	@Email(message="O email deve ser válido")
	private String email;

	@NotBlank(message="A descrição não pode ser vazia")
	@Length(max = 400,message="A descrição deve ter menos de 400 caracteres")
	private String descricao;

	@Deprecated
	public CadastroAutorForm() {
	}

	public CadastroAutorForm(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Length(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor toModel() {
		var autor = new Autor(this.nome, this.email, this.descricao);
		return autor;
	}

}
