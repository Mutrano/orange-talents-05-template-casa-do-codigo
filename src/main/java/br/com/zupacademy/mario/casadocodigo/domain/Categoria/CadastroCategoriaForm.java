package br.com.zupacademy.mario.casadocodigo.domain.Categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mario.casadocodigo.domain.validation.UniqueValue;

public class CadastroCategoriaForm {
	@UniqueValue(entidade = Categoria.class,campo = "nome",message="nome ja existente")
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
