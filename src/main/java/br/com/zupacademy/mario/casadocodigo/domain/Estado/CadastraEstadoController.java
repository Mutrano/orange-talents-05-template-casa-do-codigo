package br.com.zupacademy.mario.casadocodigo.domain.Estado;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mario.casadocodigo.domain.shared.UniqueWithinAnotherValidator;

@RestController
@RequestMapping("/Estados")
public class CadastraEstadoController {
	
	@Autowired
	UniqueWithinAnotherValidator uniqueWithinAnotherValidator;
	
	@InitBinder
	void init(WebDataBinder binder) {
		binder.addValidators(uniqueWithinAnotherValidator);
	}
	
	@Autowired
	private EntityManager em;

	@Transactional
	@PostMapping
	public ResponseEntity<Void> cadastraEstado(@RequestBody @Valid CadastraEstadoForm form) {
		var estado = form.toModel(em);

		em.persist(estado);

		return ResponseEntity.ok().build();
	}

}
