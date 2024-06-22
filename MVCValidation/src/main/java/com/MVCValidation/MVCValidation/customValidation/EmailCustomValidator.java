package com.MVCValidation.MVCValidation.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailCustomValidator implements ConstraintValidator<CustomValAnnotation, String>{

	public String paramValue; 
	
	@Override
	public void initialize(CustomValAnnotation context)
	{
		paramValue = context.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null != value || !value.isBlank()) 
		{
			return value.endsWith(paramValue);
		}
		else
		{
			return false;
		}
	}

}
