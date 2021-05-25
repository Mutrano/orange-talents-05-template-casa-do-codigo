package br.com.zupacademy.mario.casadocodigo.domain.Estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mario.casadocodigo.domain.Pais.Pais;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotNull
	@ManyToOne
	private Pais pais;

	@Deprecated
	private Estado() {

	}

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public boolean estadoEhDoPais(Long estadoId, Long paisId, EstadoRepository repository) {
		var estadoEncontrado = repository.findByIdAndPaisId(estadoId, paisId);

		return estadoEncontrado.isPresent();

	}
	public Pais getPais() {
		return pais;
	}

}
