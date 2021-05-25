package br.com.zupacademy.mario.casadocodigo.domain.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.mario.casadocodigo.domain.Cliente.CadastroClienteForm;
import br.com.zupacademy.mario.casadocodigo.domain.Estado.EstadoRepository;

@Component
public class OpcionalidadeEstadoValidator implements Validator {


	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CadastroClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if (errors.hasErrors()) {
			return;
		}

		var form = (CadastroClienteForm) target;

		var estadoId = form.getEstadoId();
		var paisId = form.getPaisId();
		
		if (estadoId ==null) {
			var possivelEstado = estadoRepository.findByPaisId(paisId);
			if(!possivelEstado.isEmpty()) {
				errors.rejectValue("estadoId", null, "Um estado deve ser selecionado no país informado");
			}
		}
	}

}
