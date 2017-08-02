/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(urlPatterns = "/*", name = "AppUIServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = AppUI.class, productionMode = false)
public class AppUIServlet extends VaadinServlet {
	private static final long serialVersionUID = 1L;
}