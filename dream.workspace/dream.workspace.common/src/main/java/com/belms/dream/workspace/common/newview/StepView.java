/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.newview;

import com.belms.dream.api.view.EntryView;

public interface StepView<T> extends EntryView<T>  {
	String getName();
	boolean validationRequired();
	boolean skipThisStep();

}
