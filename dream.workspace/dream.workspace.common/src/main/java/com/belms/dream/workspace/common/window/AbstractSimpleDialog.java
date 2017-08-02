/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.window;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractSimpleDialog  extends Window implements View {

	private static final long serialVersionUID = 1L;
	private String addButtonCaption = "Add";
	private String editButtonCaption = "Edit";
	private ClickListener okButtonClickListener;
	private List<Button> moreButtons ;
	private OPER_TYPE type = OPER_TYPE.CONFIRM;
	

	@Override
	public void initView() {
		buildUi();
		
	}
	
	protected void setOpterationType(OPER_TYPE type) {
		this.type = type;
	}

	
	protected OPER_TYPE getOperationType() {
		return type;
	}
	
	private void buildUi() {
		
		if( getOperationType()==OPER_TYPE.CONFIRM) {
			setCaption( String.format("<h3><b>%s</h3></b>", getDialogCaption()));	
		}else {
			setCaption( String.format("<h3><b>%s %s</h3></b>", getOperationType()==OPER_TYPE.ADD?"Add New":"Edit",  getDialogCaption()));	
		}
		
		setCaptionAsHtml(true);
		setModal(true);
		center();
		
		final VerticalLayout root = new VerticalLayout();
		setContent(root);
		
		root.setSizeFull();
		root.setMargin(false);
		root.setSpacing(false);
		buildContentLayout(root);
		buildButons(root);
	}
	
	protected abstract String getDialogCaption();
	protected abstract void buildContentLayout(final VerticalLayout parent);
	protected void setOKButtonCaption(String caption) {
		this.addButtonCaption = caption;
	}
	
	protected void setOkButtonClickListener(final ClickListener clickListener) {
		this.okButtonClickListener = clickListener;
	}
	
	protected void addMoreButton(Button button) {
		if(moreButtons == null) {
			moreButtons = new ArrayList<>();
		}
		
		moreButtons.add(button);
	}
	
	
	private void buildButons(final VerticalLayout layout){
		final HorizontalLayout footerLayout = new HorizontalLayout();
		layout.addComponent(footerLayout);
		footerLayout.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
		footerLayout.setWidth(100, Unit.PERCENTAGE);
		footerLayout.setHeight(50,Unit.PIXELS);
		footerLayout.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
		footerLayout.setMargin(false);
		footerLayout.setSpacing(false);
		
		CssLayout group = new CssLayout();
		group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		footerLayout.addComponent(group);
		
		if(moreButtons!=null) {
			
			for (Button button : moreButtons) {
				group.addComponent(button);
			}
			
		}
		
	
		final Button okButton = new Button( getOperationType()==OPER_TYPE.ADD?addButtonCaption:editButtonCaption);
		
		if(getOperationType()==OPER_TYPE.CONFIRM) {
			okButton.setCaption(addButtonCaption);
		}
		
		group.addComponent(okButton);
		
		if(okButtonClickListener!=null) {
			
			okButton.addClickListener(this.okButtonClickListener);
		}
		
		final Button cancelButton = new Button( getOperationType()==OPER_TYPE.CONFIRM?"No":"Cancel");
		group.addComponent(cancelButton);
		
		cancelButton.addClickListener(event -> {
			close();
		});
		
	}
	
	
	

}
