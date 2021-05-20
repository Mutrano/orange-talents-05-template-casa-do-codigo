package br.com.zupacademy.mario.casadocodigo.domain.shared;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValueExistsValidator implements ConstraintValidator<ValueExists, Object> {

	private Class<?> entidade;
	private String campo;

	@PersistenceContext
	EntityManager em;

	@Override
	public void initialize(ValueExists constraintAnnotation) {
		this.entidade = constraintAnnotation.entidade();
		this.campo = constraintAnnotation.campo();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var query = em.createQuery("select 1 from " + entidade.getName() + " where " + campo + "= :pValue");
		query.setParameter("pValue", value);

		var result = query.getResultList();
		return !result.isEmpty();
	}

}
