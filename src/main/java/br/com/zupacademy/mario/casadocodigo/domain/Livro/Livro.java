package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import br.com.zupacademy.mario.casadocodigo.domain.Autor.Autor;
import br.com.zupacademy.mario.casadocodigo.domain.Categoria.Categoria;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(unique = true)
	private String titulo;
	
	@Size(max = 500)
	@NotBlank
	private String resumo;
	
	@Lob
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@Min(value = 100)
	private Integer paginas;
	

	@NotBlank
	@Column(unique = true)
	@ISBN(type = Type.ANY)
	private String isbn;
	
	@NotNull()
	@Future(message = "A data de publicação deve ser no futuro")
	private LocalDate dataDePublicacao;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;
	
	@ManyToOne
	@NotNull
	private Autor autor;
	
	@Deprecated
	public Livro() {
		
	}
	public Livro(String titulo, @Size(max = 500) @NotBlank String resumo, String sumario, BigDecimal preco,
			@Size(min = 100) Integer paginas, @NotBlank @ISBN(type = Type.ANY) String isbn,
			@Future LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
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
	public Autor getAutor() {
		return autor;
	}
	
}
