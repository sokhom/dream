/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import com.belms.dream.workspace.ui.event.AppEventBus;
import com.belms.dream.workspace.ui.event.AppEvents.PostViewChangeEvent;
import com.belms.dream.workspace.ui.fragment.UIFragmentProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

public class AppNavigator extends Navigator {

	private static final long serialVersionUID = 1L;

	// private static final AppViewType ERROR_VIEW = null;
	// //AppViewType.DASHBOARD;
	// private ViewProvider errorViewProvider;

	public AppNavigator(final ComponentContainer container) {
		super(UI.getCurrent(), container);
		initViewProviders();
		initViewChangeListener();

	}

	@SuppressWarnings("serial")
	private void initViewChangeListener() {
		addViewChangeListener(new ViewChangeListener() {

			@Override
			public boolean beforeViewChange(final ViewChangeEvent arg0) {
				return true;
			}

			@Override
			public void afterViewChange(final ViewChangeEvent event) {
				NavigatorViewType view = UIFragmentProvider.geNavigatorViewType(event.getViewName());// AppViewType.getByViewName(event.getViewName());
				AppEventBus.post(new PostViewChangeEvent(view));

			}

		});
	}

	@SuppressWarnings("serial")
	private void initViewProviders() {
		
		ViewProvider defultViewProvider = null;
		
		
		for (final NavigatorViewType navigatorViewType : UIFragmentProvider.getNavigatorTypes()) {
			
			ViewProvider viewProvider = new ViewProvider() {

				private View cachedInstance =null;

				@Override
				public String getViewName(String navigationState) {

					if (null == navigationState) {
						return null;
					}

					if (navigationState.equalsIgnoreCase(navigatorViewType.getViewName())) {
						return navigatorViewType.getViewName();
					}
					return "main";
				}

				@Override
				public View getView(String viewName) {

					if (navigatorViewType.getViewName().equals(viewName)) {
						if (navigatorViewType.isStateful()) {
							if (cachedInstance == null) {
								cachedInstance = new NavigateView(navigatorViewType.getFragmentFactory().getFragment(AppEventBus.getEventBusProvider()));
							}
						} else {
							cachedInstance = new NavigateView(navigatorViewType.getFragmentFactory().getFragment(AppEventBus.getEventBusProvider()));
						}

					}

					return cachedInstance;
				}
			};

			if(navigatorViewType.isDefaultView()){
				defultViewProvider= viewProvider;
			}
			
			addProvider(viewProvider);
		}
		
		if(defultViewProvider!=null){
			setErrorProvider(defultViewProvider);
		}

	}

}