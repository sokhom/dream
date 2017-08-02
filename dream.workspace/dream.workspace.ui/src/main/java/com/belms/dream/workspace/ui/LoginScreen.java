/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import java.io.Serializable;

import com.belms.dream.workspace.ui.authentication.AccessControl;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class LoginScreen extends CssLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextField username;
	private PasswordField password;
	private Button login;
//	private Button forgotPassword;

	private AccessControl accessControl;
	private LoginListener loginListener;

	public LoginScreen(AccessControl accessControl, LoginListener loginListener) {
		this.accessControl = accessControl;
		this.loginListener = loginListener;
		buildUI();
		username.focus();
	}

	private void buildUI() {
		addStyleName("login-screen");

		// login form, centered in the available part of the screen
		Component loginForm = buildLoginForm();

		// layout to center login form when there is sufficient screen space
		// - see the theme for how this is made responsive for various screen
		// sizes
		VerticalLayout centeringLayout = new VerticalLayout();
		centeringLayout.setMargin(false);
		centeringLayout.setSpacing(false);
		centeringLayout.setStyleName("centering-layout");
		centeringLayout.addComponent(loginForm);
		centeringLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

		CssLayout loginInformation = buildLoginInformation();

		addComponent(centeringLayout);
		addComponent(loginInformation);

	}

	private Component buildLoginForm() {
		FormLayout loginForm = new FormLayout();

		loginForm.setSizeUndefined();
		loginForm.setMargin(false);

		loginForm.addComponent(username = new TextField("Username", "admin"));
		username.setWidth(15, Unit.EM);

		loginForm.addComponent(password = new PasswordField("Password"));
		password.setWidth(15, Unit.EM);

		password.setDescription("Write anything");
		CssLayout buttons = new CssLayout();
		buttons.setStyleName("buttons");
		loginForm.addComponent(buttons);

		buttons.addComponent(login = new Button("Login"));
		login.setDisableOnClick(true);
		login.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(Button.ClickEvent event) {
				try {
					login();
				} finally {
					login.setEnabled(true);
				}
			}
		});

		login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

		return loginForm;
	}

	private CssLayout buildLoginInformation() {
		CssLayout loginInformation = new CssLayout();
		loginInformation.setStyleName("login-information");
		Label loginInfoText = new Label("<h1>I'm not a dreamer</h1>" + "Please join us &quot;Better Elements Team&quot; to make sth possible",
				ContentMode.HTML);
		loginInfoText.setSizeFull();
		loginInformation.addComponent(loginInfoText);
		return loginInformation;
	}

	private void login() {
		if (accessControl.signIn(username.getValue(), password.getValue())) {
			loginListener.loginSuccessful();
		} else {
			showNotification(new Notification("Login failed", "Please check your username and password and try again.",
					Notification.Type.HUMANIZED_MESSAGE));
			username.focus();
		}
	}

	private void showNotification(Notification notification) {
		// keep the notification visible a little while after moving the
		// mouse, or until clicked
		notification.setDelayMsec(2000);
		notification.show(Page.getCurrent());
	}

	public interface LoginListener extends Serializable {
		void loginSuccessful();
	}

}