/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.validator;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class TextRequiredValidator implements Validator<String>{

	private static final long serialVersionUID = 1L;

	@Override
	public ValidationResult apply(String value, ValueContext context) {
		if(value !=null && ! value.isEmpty()) {
			return ValidationResult.ok();	
		}
		return ValidationResult.error("Input is required");
		
	}

}
