package br.com.zupacademy.mario.casadocodigo.domain.Autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<Void> CriaAutor(@RequestBody @Valid  CadastroAutorForm cadastroAutorForm) {
		var autor = cadastroAutorForm.toModel();
		autorRepository.save(autor);
		
		return ResponseEntity.ok().build();
	}
}
