/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.validator;

import com.blems.dream.api.model.BasedModel;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class RequiredValidator implements Validator<BasedModel> {

	private static final long serialVersionUID = 1L;

	@Override
	public ValidationResult apply(BasedModel value, ValueContext context) {

		if(value!=null) {
			return ValidationResult.ok();
		}
		
		return ValidationResult.error("Input is required");
	}

}
