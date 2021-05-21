package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import java.math.BigDecimal;

import javax.validation.Valid;

public class DetalhesLivro {

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private Integer paginas;

	private String isbn;

	private String nomeAutor;

	private String descricaoAutor;

	public DetalhesLivro(@Valid Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
}
