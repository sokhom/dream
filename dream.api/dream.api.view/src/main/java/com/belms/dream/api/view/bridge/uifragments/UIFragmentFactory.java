/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.view.bridge.uifragments;

import com.belms.dream.api.view.event.EventBusProvider;
import com.vaadin.ui.Component;

public interface UIFragmentFactory {
	UIFragmentInfo getUIFagmentInfo();
	Component getFragment(EventBusProvider eventBusProvider);
}
