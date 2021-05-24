package br.com.zupacademy.mario.casadocodigo.domain.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mario.casadocodigo.domain.Estado.CadastraEstadoForm;
import br.com.zupacademy.mario.casadocodigo.domain.Estado.EstadoRepository;

@Component
public class UniqueWithinAnotherValidator implements Validator {

	@Autowired
	private EstadoRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CadastraEstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		var form = (CadastraEstadoForm) target;
		var nome = form.getNome();
		var paisId = form.getPaisId();

		var estadoEncontrado = repository.findByNomeAndPaisId(nome, paisId);

		estadoEncontrado
				.ifPresent(x-> errors.rejectValue("nome", null, "Estado ja existente no país de id=" + paisId));

	}
}
