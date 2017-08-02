/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import com.belms.dream.workspace.ui.fragment.UIFragmentProvider;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class MainScreen extends HorizontalLayout {

	private static final long serialVersionUID = 1L;
	
	public MainScreen(AppUI ui) {
		setSpacing(false);
		addStyleName("mainview");
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
//        viewContainer.addStyleName("view-content");
        viewContainer.setSizeFull();
        
        
        UIFragmentProvider.init();
      
        addComponent(new AppMenu());
        
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
        new AppNavigator(viewContainer);
	}
	

}
