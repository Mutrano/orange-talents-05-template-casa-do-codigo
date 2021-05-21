package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/Livros")
public class MostraLivroController {
	@Autowired		
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ItemListaLivro>> listaLivros(){
		var livros = repository.findAll();
		
		var listaItensLivro = livros.stream()
				.map(livro -> new ItemListaLivro(livro.getId(), livro.getTitulo()))
					.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaItensLivro);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivro> detalhaLivro(@PathVariable Long id) {
		var livroEncontrado = repository.findById(id);
		
		var livro = livroEncontrado.orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"id " + id + " não encontrado no sistema"));
		
		var detalhesLivro = new DetalhesLivro(livro);
		
		return ResponseEntity.ok().body(detalhesLivro);

	}
}
