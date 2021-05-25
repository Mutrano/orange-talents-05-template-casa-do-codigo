package br.com.zupacademy.mario.casadocodigo.domain.Cliente;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mario.casadocodigo.domain.Estado.EstadoRepository;
import br.com.zupacademy.mario.casadocodigo.domain.Pais.Pais;
import br.com.zupacademy.mario.casadocodigo.domain.shared.EstadoPertenceAoPaisValidator;
import br.com.zupacademy.mario.casadocodigo.domain.shared.OpcionalidadeEstadoValidator;

@RestController
@RequestMapping("/Clientes")
public class CadastraClienteController {
	@Autowired
	private EntityManager em;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;

	@Autowired
	private OpcionalidadeEstadoValidator opcionalidadeEstadoValidator;

	@InitBinder
	void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAoPaisValidator, opcionalidadeEstadoValidator);
	}

	@PostMapping
	public ResponseEntity<Long> cadastraCliente(@RequestBody @Valid CadastroClienteForm form) {
		var estadoId = form.getEstadoId();
		var paisId = form.getPaisId();

		var paisEncontrado = em.find(Pais.class, paisId);
		Cliente cliente;

		if (estadoId != null) {
			var estadoEncontrado = estadoRepository.findById(estadoId).get();
			cliente = form.toModel(estadoEncontrado, paisEncontrado);
		} 
		else {
			cliente = form.toModel(null, paisEncontrado);
		}

		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok().body(cliente.getId());

	}

}
