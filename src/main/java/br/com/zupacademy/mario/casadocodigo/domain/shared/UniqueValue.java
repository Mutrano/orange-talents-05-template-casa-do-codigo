package br.com.zupacademy.mario.casadocodigo.domain.shared;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD,METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

	String message() default "Valor ja existe no sistema";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	Class<?> entidade() ;
	String campo() ;
	
}
