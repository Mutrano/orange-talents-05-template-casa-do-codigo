package br.com.zupacademy.mario.casadocodigo.domain.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mario.casadocodigo.domain.Autor.CadastroAutorForm;

@Component
public class ProibeNomeDuplicadoValidator implements Validator  {

	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//se ja teve algum erro de validação simplesmente retorna logo.
		if(errors.hasErrors()) {
			return;
		}
		
		var form = (CadastroCategoriaForm) target;
		
		var categoriaEncontrada = categoriaRepository.findByNome(form.getNome());
		
		if(categoriaEncontrada.isPresent()) {
			errors.rejectValue("nome", null, "O nome ja está cadastrado no sistema");
		}
	}

}
