/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.customer;

import com.belms.dream.api.view.bridge.uifragments.UIFragmentFactory;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo.VIEW_LEVEL;
import com.belms.dream.api.view.event.EventBusProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;

public class CustomerFragmentFactory implements UIFragmentFactory {

	@Override
	public UIFragmentInfo getUIFagmentInfo() {
		UIFragmentInfo fragmentInfo = new UIFragmentInfo();
		fragmentInfo.setIcon(VaadinIcons.HOME);
		fragmentInfo.setId("customer");
		fragmentInfo.setName("Customer");
		fragmentInfo.setViewLevel(VIEW_LEVEL.LEVEL1);
		fragmentInfo.setNavigateName("customer");
		fragmentInfo.setAccessCode("100-001");
		fragmentInfo.setDisplaySeq(1);
		fragmentInfo.setNavigate(true);
		return fragmentInfo;
	}

	@Override
	public Component getFragment(EventBusProvider eventBusProvider) {
		
		System.out.println("create view");
		return new CustomerViewImpl(eventBusProvider);
	}


}
