package com.github.imNirav.java.validator;


import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author Narender
 *
 */
public class CheckForNullValidator implements ConstraintValidator<CheckForNull, Object> {

	private String[] required;
	private String message;

	@Override
	public void initialize(CheckForNull constraintAnnotation) {
		required = constraintAnnotation.required();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
		Boolean valid = true;

		for (String propName : required) {
			Object requiredValue;
			try {
				requiredValue = BeanUtils.getProperty(objectToValidate, propName);
				valid = !(ObjectUtils.isEmpty(requiredValue));
				if (!valid) {
					context.disableDefaultConstraintViolation();

					if (CheckForNullConstants.DEFAULT_MSG.equals(message)) {
						context.buildConstraintViolationWithTemplate(message).addPropertyNode(propName)
								.addConstraintViolation();
					} else {
						context.buildConstraintViolationWithTemplate(","+message).addPropertyNode(propName)
						.addConstraintViolation();
					}
					return valid;
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				// No need to print exception, because we are validating generic
				// object
			}

		}
		return valid;
	}

}
