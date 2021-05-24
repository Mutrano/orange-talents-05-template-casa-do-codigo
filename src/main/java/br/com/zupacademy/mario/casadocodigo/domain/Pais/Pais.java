package br.com.zupacademy.mario.casadocodigo.domain.Pais;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mario.casadocodigo.domain.Estado.Estado;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String nome;

	@OneToMany(mappedBy = "pais")
	private Set<Estado> estados = new HashSet<>();
	
	@Deprecated
	private Pais() {
		
	}
	
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	public Set<Estado> getEstados() {
		return estados;
	}

}
