package br.com.zupacademy.mario.casadocodigo.domain.Pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Paises")
public class CadastraPaisController {

	@Autowired
	private PaisRepository repository;

	@PostMapping
	public ResponseEntity<Void> cadastraPais(@RequestBody @Valid CadastraPaisForm form) {
		var pais = form.toModel();
		
		repository.save(pais);
		return ResponseEntity.ok().build();
	}

}
