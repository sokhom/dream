package com.belms.dream.api.view.fragment;

import com.belms.dream.api.view.event.EventBusProvider;
import com.vaadin.ui.Component;

public interface FragmentFactory {
	
	FragmentInfo getFragmentInfo();
	
	Component getFragment(EventBusProvider eventBusProvider);
	
	
}
