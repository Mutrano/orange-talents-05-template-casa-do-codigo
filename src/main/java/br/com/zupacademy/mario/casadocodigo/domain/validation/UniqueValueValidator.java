package br.com.zupacademy.mario.casadocodigo.domain.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {
	private Class<?> entidade;
	private String campo;

	@PersistenceContext
	EntityManager em;

	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		this.entidade = constraintAnnotation.entidade();
		this.campo = constraintAnnotation.campo();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		var query = em.createQuery("select 1 from " + entidade.getName() + " where " + campo + "= :pValue");
		query.setParameter("pValue", value);

		var result = query.getResultList();

		return result.isEmpty();
	}
}