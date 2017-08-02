/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import com.belms.dream.workspace.ui.authentication.AccessControl;
import com.belms.dream.workspace.ui.authentication.BasicAccessControl;
import com.belms.dream.workspace.ui.event.AppEventBus;
import com.belms.dream.workspace.ui.event.AppEvents.UserLoggedOutEvent;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("theme")
public class AppUI extends UI {
	
	private static final long serialVersionUID = 1L;

	private final AppEventBus appEventbus = new AppEventBus();

	private AccessControl accessControl = new BasicAccessControl();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		setLocale(vaadinRequest.getLocale());
		AppEventBus.register(this);
		getPage().setTitle("Dream");

		if (!accessControl.isUserSignedIn()) {
			setContent(new LoginScreen(accessControl,()->showMainView()));
		} else {
			showMainView();
		}
	}

	protected void showMainView() {
		addStyleName(ValoTheme.UI_WITH_MENU);
		setContent(new MainScreen(AppUI.this));
		getNavigator().navigateTo(getNavigator().getState());
	}

	
    public static AppEventBus getAppEventBus() {
		return ((AppUI) getCurrent()).appEventbus;
	}
    
    @Subscribe
	public void userLoggedOut(final UserLoggedOutEvent event) {
		// When the user logs out, current VaadinSession gets closed and the
		// page gets reloaded on the login screen. Do notice the this doesn't
		// invalidate the current HttpSession.
		  VaadinSession.getCurrent().getSession().invalidate();
          Page.getCurrent().reload();
    }
    
}
