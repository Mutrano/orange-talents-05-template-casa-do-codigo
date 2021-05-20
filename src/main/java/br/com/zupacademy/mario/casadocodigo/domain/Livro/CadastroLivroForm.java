package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.mario.casadocodigo.domain.Autor.Autor;
import br.com.zupacademy.mario.casadocodigo.domain.Categoria.Categoria;
import br.com.zupacademy.mario.casadocodigo.domain.shared.UniqueValue;
import br.com.zupacademy.mario.casadocodigo.domain.shared.ValueExists;

public class CadastroLivroForm {

	@UniqueValue(entidade = Livro.class, campo = "titulo")
	@NotBlank
	private String titulo;

	@Size(max = 500)
	@NotBlank
	private String resumo;

	private String sumario;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@Min(value = 100)
	private Integer paginas;

	@UniqueValue(entidade = Livro.class, campo = "isbn")
	@NotBlank
	@ISBN(type = Type.ANY)
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	@Future
	private LocalDate dataDePublicacao;
	
	@ValueExists(entidade = Autor.class, campo = "id")
	@NotNull
	private Long autorId;

	@ValueExists(entidade = Categoria.class, campo = "id")
	@NotNull
	private Long categoriaId;

	@Deprecated
	public CadastroLivroForm() {

	}

	public CadastroLivroForm(String titulo, @Size(max = 500) @NotBlank String resumo, String sumario, BigDecimal preco,
			@Size(min = 100) Integer paginas, @NotBlank @ISBN(type = Type.ANY) String isbn,
			@Future LocalDate dataDePublicacao, Long categoriaId, Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro toModel(EntityManager em) {
		var queryCategoria = em.createQuery("Select c from Categoria c where id = :pId");
		queryCategoria.setParameter("pId", categoriaId);
		List<Categoria> categoriaList = queryCategoria.getResultList();
		var categoria = categoriaList.get(0);

		var queryAutor = em.createQuery("Select a from Autor a where id = :pId");
		queryAutor.setParameter("pId", autorId);
		List<Autor> autorList = queryAutor.getResultList();
		var autor = autorList.get(0);

		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataDePublicacao, categoria, autor);

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

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
}