package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemListaLivro {
	@NotNull
	private Long id;
	
	@NotBlank
	private String titulo;
	
	public ItemListaLivro(@NotNull Long id, @NotBlank String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}


}
