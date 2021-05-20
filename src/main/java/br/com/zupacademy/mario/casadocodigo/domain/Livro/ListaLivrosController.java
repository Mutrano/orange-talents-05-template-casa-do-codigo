package br.com.zupacademy.mario.casadocodigo.domain.Livro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Livros")
public class ListaLivrosController {
	@Autowired		
	private LivroRepository livroRepository;
	
	@GetMapping
	public ResponseEntity<List<ItemListaLivro>> listaLivros(){
		var livros = livroRepository.findAll();
		
		var listaItensLivro = livros.stream()
				.map(livro -> new ItemListaLivro(livro.getId(), livro.getTitulo()))
					.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaItensLivro);
		
	}
	
	
}
