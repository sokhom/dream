/***
 * @author haysokhom
 * 
 */
package com.belms.dream.workspace.part;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentFactory;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo.VIEW_LEVEL;
import com.belms.dream.api.view.event.EventBusProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;

public class PartFragmentFactory implements UIFragmentFactory {

	
	@Override
	public UIFragmentInfo getUIFagmentInfo() {
		UIFragmentInfo fragmentInfo = new UIFragmentInfo();
		fragmentInfo.setIcon(VaadinIcons.HOME);
		fragmentInfo.setId("part");
		fragmentInfo.setName("Part");
		fragmentInfo.setViewLevel(VIEW_LEVEL.LEVEL1);
		fragmentInfo.setNavigateName("part");
		fragmentInfo.setAccessCode("100-002");
		fragmentInfo.setDisplaySeq(1);
		fragmentInfo.setNavigate(true);
		return fragmentInfo;
	}

	@Override
	public Component getFragment(EventBusProvider eventBusProvider) {
		
		System.out.println("create view part");
//		return new CustomerViewImpl(eventBusProvider);
		return new PartViewImp(eventBusProvider);
	}


}
