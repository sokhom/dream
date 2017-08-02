/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.dialog;

import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ConfirmDialog {

	public static void showDialog(final String message, final ClickListener clickListener) {

		AbstractSimpleDialog window = new Dialog(message, clickListener);
		window.initView();

		UI.getCurrent().addWindow(window);
	}

	private static class Dialog extends AbstractSimpleDialog {

		private static final long serialVersionUID = 1L;
		private final String message;

		public Dialog(String message, ClickListener clickListener) {
			setWidth(500, Unit.PIXELS);
			setHeight(300, Unit.PIXELS);
			this.message = message;
			setOpterationType(OPER_TYPE.CONFIRM);
			setOKButtonCaption("Yes");
			setOkButtonClickListener(event -> {
				clickListener.buttonClick(event);
				close();
			});
		}

		@Override
		protected String getDialogCaption() {
			return "Confirmation Dialog";
		}

		@Override
		protected void buildContentLayout(VerticalLayout parent) {
			final VerticalLayout layout = new VerticalLayout(new Label(String.format("<H3>%s</H3>", message), ContentMode.HTML));
			parent.addComponent(layout);
			
			parent.setExpandRatio(layout, 1);

		}
	}

}
