/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.newview;

public class StepViewSelectedEvent<T> {
	
	private final StepView<T> stepView;
	
	public StepViewSelectedEvent(final StepView<T> stepView) {
		this.stepView = stepView;
	}

	public StepView<T> getStepView() {
		return stepView;
	}
	
	

}
