/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import com.belms.dream.workspace.ui.authentication.CurrentUser;
import com.belms.dream.workspace.ui.event.AppEventBus;
import com.belms.dream.workspace.ui.event.AppEvents;
import com.belms.dream.workspace.ui.fragment.UIFragmentProvider;
import com.google.common.eventbus.Subscribe;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

public class AppMenu extends CustomComponent {

	private static final long serialVersionUID = 1L;

	public static final String ID = "app-menu";
	public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
	public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
	private static final String STYLE_VISIBLE = "valo-menu-visible";
	private MenuItem settingsItem;

	public AppMenu() {
		setPrimaryStyleName("valo-menu");
		setId(ID);
		setSizeUndefined();
		AppEventBus.register(this);
		setCompositionRoot(buildContent());

	}

	private Component buildContent() {
		final CssLayout menuContent = new CssLayout();
		menuContent.addStyleName("sidebar");
		menuContent.addStyleName(ValoTheme.MENU_PART);
		menuContent.addStyleName("no-vertical-drag-hints");
		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth(null);
		menuContent.setHeight("100%");

		menuContent.addComponent(buildTitle());
		menuContent.addComponent(buildUserMenu());
		menuContent.addComponent(buildToggleButton());
		menuContent.addComponent(buildMenuItems());

		return menuContent;
	}

	private Component buildTitle() {
		Label logo = new Label("Dream - <strong>Better Elms</strong>", ContentMode.HTML);
		logo.setSizeUndefined();

		HorizontalLayout logoWrapper = new HorizontalLayout(logo);
		logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
		logoWrapper.addStyleName("valo-menu-title");
		logoWrapper.setSpacing(false);
		return logoWrapper;

	}

	private Component buildUserMenu() {
		final MenuBar settings = new MenuBar();
		settings.addStyleName("user-menu");
		final String user = CurrentUser.get();
		settingsItem = settings.addItem("", new ThemeResource("img/profile-pic-300px.jpg"), null);
		settingsItem.setText(user);
		// updateUserName(null);
		settingsItem.addItem("Edit Profile", selectedItem -> {});
		settingsItem.addItem("Preferences", selectedItem -> {});
		settingsItem.addSeparator();
		settingsItem.addItem("Sign Out", selectedItem -> AppEventBus.post(new AppEvents.UserLoggedOutEvent()));
		return settings;
	}

	private Component buildToggleButton() {
		Button valoMenuToggleButton = new Button("Menu", event -> {
			if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
				getCompositionRoot().removeStyleName(STYLE_VISIBLE);
			} else {
				getCompositionRoot().addStyleName(STYLE_VISIBLE);
			}
		});
		valoMenuToggleButton.setIcon(VaadinIcons.LIST);
		valoMenuToggleButton.addStyleName("valo-menu-toggle");
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
		return valoMenuToggleButton;
	}

	private Component buildMenuItems() {
		CssLayout menuItemsLayout = new CssLayout();
		menuItemsLayout.addStyleName("valo-menuitems");

		for (NavigatorViewType navigatorViewType : UIFragmentProvider.getMainMenu()) {
			Component menuItemComponent = new ValoMenuItemButton(navigatorViewType);
			;
			menuItemsLayout.addComponent(menuItemComponent);
		}
		return menuItemsLayout;
	}

	public final class ValoMenuItemButton extends Button {
		
		private static final long serialVersionUID = 1L;

		private static final String STYLE_SELECTED = "selected";

		private final NavigatorViewType view;

		public ValoMenuItemButton(final NavigatorViewType view) {
			this.view = view;
			setPrimaryStyleName("valo-menu-item");
			setIcon(view.getIcon());
			setCaption(view.getViewName().substring(0, 1).toUpperCase() + view.getViewName().substring(1));
			AppEventBus.register(this);
			addClickListener(event->UI.getCurrent().getNavigator().navigateTo(view.getViewName()));

		}

		@Subscribe
		public void postViewChange(final AppEvents.PostViewChangeEvent event) {
			removeStyleName(STYLE_SELECTED);
			if (event.getView().getId().equals(view.getId())) {
				addStyleName(STYLE_SELECTED);
			}
		}
	}

}