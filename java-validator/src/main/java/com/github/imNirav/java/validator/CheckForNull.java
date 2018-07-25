package com.github.imNirav.java.validator;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Narender
 *
 */
@Constraint(validatedBy = { CheckForNullValidator.class })
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckForNull {

	String message() default CheckForNullConstants.DEFAULT_MSG;
	
	String[] required();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
