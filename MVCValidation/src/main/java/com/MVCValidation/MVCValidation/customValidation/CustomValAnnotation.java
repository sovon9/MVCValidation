package com.MVCValidation.MVCValidation.customValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailCustomValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValAnnotation {

	public String value() default "@cognizant.com"; // providing default value if we didn't pass any value with annotation
	
	// providing default value if we didn't provided any error message to show with annotation
	public String message() default "email should be ending with @cognizant.com";
	
	//if we want to group constraints
	Class<?>[] groups() default { };

	// provides custom details about validation
	Class<? extends Payload>[] payload() default { };
	
}
