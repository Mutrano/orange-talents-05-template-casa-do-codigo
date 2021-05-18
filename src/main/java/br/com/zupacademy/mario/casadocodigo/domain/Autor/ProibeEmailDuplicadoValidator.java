package br.com.zupacademy.mario.casadocodigo.domain.Autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroAutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		var autor = (CadastroAutorForm) target;
		System.out.println(autor.getEmail());
		Optional<Autor> emailDuplicado = autorRepository.findByEmail(autor.getEmail());
		if(emailDuplicado.isPresent()) {
			errors.rejectValue("email", null, "email já cadastrado no sistema");
		}
	}

}
