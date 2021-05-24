package br.com.zupacademy.mario.casadocodigo.domain.Pais;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mario.casadocodigo.domain.shared.UniqueValue;

public class CadastraPaisForm {
	
	@UniqueValue(entidade = Pais.class,campo = "nome",message = "o nome do país deve ser único")
	@NotBlank
	private String nome;
	
	private CadastraPaisForm() {}

	public CadastraPaisForm(@Valid String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	public String getNome() {
		return nome;
	}
	
}
