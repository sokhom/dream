/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.address.newview;

import java.util.List;

import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.belms.dream.workspace.common.validator.TextRequiredValidator;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.blems.dream.api.model.contact.Contact;
import com.blems.dream.api.model.contact.ContactType;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ContactAddNewView extends AbstractSimpleDialog {

	private static final long serialVersionUID = 1L;
	private final List<ContactType> contactTypes;
	private final SaveEntityListener<Contact> saveEntityListener;
	
	public ContactAddNewView(SaveEntityListener<Contact> saveEntityListener,  List<ContactType> contactTypes) {
		this(saveEntityListener, OPER_TYPE.ADD, contactTypes);
	}
	
	public ContactAddNewView(SaveEntityListener<Contact> saveEntityListener,OPER_TYPE type ,  List<ContactType> contactTypes) {
		this.saveEntityListener = saveEntityListener;
		this.contactTypes = contactTypes;
		setOpterationType(type);
		setWidth(500,Unit.PIXELS);
		setHeight(300,Unit.PIXELS);
	}
	

	@Override
	protected String getDialogCaption() {
		return "Contact";
	}
	

	@Override
	protected void buildContentLayout(VerticalLayout parent) {
		final Binder<Contact> binder = new Binder<>();
		binder.setBean(saveEntityListener.getBean(getOperationType()));
		final FormLayout formLayout = new FormLayout();
		parent.addComponent(formLayout);
		parent.setExpandRatio(formLayout, 1);
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setSizeFull();
		
		final TextField nameTextFiled = new TextField("Contact Name");
		formLayout.addComponent(nameTextFiled);
		nameTextFiled.setRequiredIndicatorVisible(true);
		nameTextFiled.focus();
	
		binder.forField(nameTextFiled).withValidator(new TextRequiredValidator()).bind(Contact::getName, Contact::setName);
				
		final ComboBox<ContactType> contactTypeComboBox = new ComboBox<>("Contact Type");
		formLayout.addComponent(contactTypeComboBox);
		contactTypeComboBox.setDataProvider(new CallbackDataProvider<ContactType, String>(query->contactTypes.stream(),query->contactTypes.size()));
		contactTypeComboBox.setRequiredIndicatorVisible(true);
		binder.forField(contactTypeComboBox).withValidator(new RequiredValidator()).bind(Contact::getType, Contact::setType);
		
		
		final TextField valueTextField = new TextField("Value");
		formLayout.addComponent(valueTextField);
		binder.forField(valueTextField).withValidator(new TextRequiredValidator()).bind( Contact::getContact, Contact::setContact);
		valueTextField.setRequiredIndicatorVisible(true);
		
		
		final CheckBox defaultCheckBox = new CheckBox("Default Contact");
		formLayout.addComponent(defaultCheckBox);
		binder.bind(defaultCheckBox, Contact::isDefaultFlag, Contact::setDefaultFlag);
		
		setOkButtonClickListener(event-> {
		
			if(!binder.validate().isOk()) {
				Notification.show("Input data is not valid", Type.ERROR_MESSAGE);
				return;
			}
			saveEntityListener.save(binder.getBean(), getOperationType());
			binder.setBean(saveEntityListener.getBean(getOperationType()));
			nameTextFiled.focus();
			if(OPER_TYPE.EDIT == getOperationType()) {
				close();
			}
			
		});
	}
	
	
	

}
