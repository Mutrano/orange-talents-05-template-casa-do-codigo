package br.com.zupacademy.mario.casadocodigo.domain.Cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mario.casadocodigo.domain.Estado.Estado;
import br.com.zupacademy.mario.casadocodigo.domain.Pais.Pais;
import br.com.zupacademy.mario.casadocodigo.domain.shared.CpfOrCnpj;
import br.com.zupacademy.mario.casadocodigo.domain.shared.UniqueValue;
import br.com.zupacademy.mario.casadocodigo.domain.shared.ValueExists;

public class CadastroClienteForm {
	@UniqueValue(entidade = Cliente.class, campo = "email", message = "O campo deve ser único no sistema")
	@NotBlank
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfOrCnpj
	@UniqueValue(entidade = Cliente.class, campo = "documento", message = "O campo deve ser único no sistema")
	@NotBlank
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@ValueExists(entidade = Pais.class, campo = "id", message = "País não existe no sistema")
	@NotNull
	private Long paisId;
	
	private Long estadoId;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public CadastroClienteForm(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente toModel(Estado estado, Pais pais) {
		var cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone,
				cep);
		if(estado!=null) {
			cliente.setEstado(estado);
		}
		return cliente;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
