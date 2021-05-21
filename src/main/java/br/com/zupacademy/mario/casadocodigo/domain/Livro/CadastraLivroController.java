package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Livros")
public class CadastraLivroController {
	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	public ResponseEntity<Void> cadastraLivro(@RequestBody @Valid CadastroLivroForm form){		
		var livro = form.toModel(em);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
}
