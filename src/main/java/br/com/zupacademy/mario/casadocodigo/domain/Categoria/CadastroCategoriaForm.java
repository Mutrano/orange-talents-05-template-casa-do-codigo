package br.com.zupacademy.mario.casadocodigo.domain.Categoria;

import javax.validation.constraints.NotBlank;

public class CadastroCategoriaForm {
	
	@NotBlank(message="o nome nao pode ser vazio")
	private String nome;
	
	@Deprecated
	public CadastroCategoriaForm() {}
	
	public CadastroCategoriaForm(@NotBlank(message = "o nome nao pode ser vazio") String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}
}
