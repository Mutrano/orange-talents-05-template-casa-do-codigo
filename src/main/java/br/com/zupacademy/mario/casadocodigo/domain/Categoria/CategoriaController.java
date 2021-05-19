package br.com.zupacademy.mario.casadocodigo.domain.Categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	private ResponseEntity<Void> cadastraCategoria(@RequestBody @Valid CadastroCategoriaForm form){
		var categoria = form.toModel();
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}
}
