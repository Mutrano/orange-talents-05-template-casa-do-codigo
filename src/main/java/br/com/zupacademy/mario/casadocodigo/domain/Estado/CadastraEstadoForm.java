package br.com.zupacademy.mario.casadocodigo.domain.Estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mario.casadocodigo.domain.Pais.Pais;
import br.com.zupacademy.mario.casadocodigo.domain.shared.ValueExists;


public class CadastraEstadoForm {
	@NotBlank
	private String nome;

	@ValueExists(entidade = Pais.class, campo = "id", message = "País não existe")
	@NotNull
	private Long paisId;

	public CadastraEstadoForm(@NotBlank String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager em) {
		var pais = em.find(Pais.class, this.paisId);

		return new Estado(this.nome, pais);

	}
}
