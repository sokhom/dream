/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.address.newview;

import java.util.ArrayList;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.common.dialog.ConfirmDialog;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.belms.dream.workspace.common.validator.TextRequiredValidator;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.address.AddressType;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.contact.Contact;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AddressAddNewView extends AbstractSimpleDialog implements SaveEntityListener<Contact> {

	private static final long serialVersionUID = 1L;
	private final AddressInitDataWrapperDto initDataWrapperDto;
	private final SaveEntityListener<Address> saveEntityListener;
	private final Address address;
	private final Grid<Contact> contactGrid = new Grid<>();

	public AddressAddNewView(final SaveEntityListener<Address> saveEntityListener, OPER_TYPE type,
			final AddressInitDataWrapperDto initDataWrapperDto) {
		this.saveEntityListener = saveEntityListener;
		this.initDataWrapperDto = initDataWrapperDto;
		setOpterationType(type);
		this.address = saveEntityListener.getBean(getOperationType());
		if (address.getContacts() == null) {
			address.setContacts(new ArrayList<>());
		}
	}

	@Override
	protected String getDialogCaption() {
		return "Contact";
	}

	@Override
	protected void buildContentLayout(VerticalLayout parent) {
		setWidth(700, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		buildAddressLayout(initDataWrapperDto, parent);
		buildContactLayout(initDataWrapperDto, parent);

	}

	private void buildAddressLayout(final AddressInitDataWrapperDto initDataWrapperDto, final VerticalLayout layout) {
		final Binder<Address> binder = new Binder<>();
		final Panel addressPanel = new Panel("Addresss Info");
		layout.addComponent(addressPanel);
		addressPanel.setSizeFull();
		layout.setExpandRatio(addressPanel, 1);

		FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setSizeFull();

		final ComboBox<AddressType> addressTypeComboBox = new ComboBox<AddressType>("Address Type");
		addressTypeComboBox.setDataProvider(
				new CallbackDataProvider<AddressType, String>(query -> initDataWrapperDto.getAddressTypes().stream(),
						query -> initDataWrapperDto.getAddressTypes().size()));
		formLayout.addComponent(addressTypeComboBox);
		addressTypeComboBox.setRequiredIndicatorVisible(true);
		addressTypeComboBox.focus();
		binder.forField(addressTypeComboBox).withValidator(new RequiredValidator()).bind(Address::getType, Address::setType);
		
		final TextField nameTextField = new TextField("Address Name");
		nameTextField.setValue("Phanny co. LTD");
		formLayout.addComponent(nameTextField);
		nameTextField.setRequiredIndicatorVisible(true);
		binder.forField(nameTextField).withValidator(new TextRequiredValidator()).bind(Address::getName, Address::setName);
		
		final TextArea addressTextArea = new TextArea("Address");
		formLayout.addComponent(addressTextArea);
		addressTextArea.setRows(2);
		addressTextArea.setRequiredIndicatorVisible(true);
		binder.forField(addressTextArea).withValidator(new TextRequiredValidator()).bind(Address::getAddress, Address::setAddress);

		final HorizontalLayout wrap = new HorizontalLayout();
		formLayout.addComponent(wrap);
		wrap.setSpacing(false);
		wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		wrap.setCaption("City/State/Zip");

		final TextField cityTextField = new TextField();

		wrap.addComponent(cityTextField);
		cityTextField.setWidth(150, Unit.PIXELS);
		cityTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		binder.forField(cityTextField).withValidator(new TextRequiredValidator()).bind(Address::getCity, Address::setCity);
		wrap.addComponent(new Label("/"));

		final ComboBox<State> stateComboBox = new ComboBox<>();

		wrap.addComponent(stateComboBox);
		stateComboBox.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		stateComboBox.setWidth(150, Unit.PIXELS);
		stateComboBox.setDataProvider(new CallbackDataProvider<State, String>(
				query -> initDataWrapperDto.getStates().stream(), qyery -> initDataWrapperDto.getStates().size()));
		binder.forField(stateComboBox).withValidator(new RequiredValidator()).bind(Address::getState, Address::setState);
		wrap.addComponent(new Label("/"));
		final TextField zipTextField = new TextField();
		zipTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		zipTextField.setWidth(100, Unit.PIXELS);
		binder.forField(zipTextField).withValidator(new TextRequiredValidator()).bind(Address::getZip, Address::setZip);
		wrap.addComponent(zipTextField);
		
		final ComboBox<Country> countryComboBox = new ComboBox<>("Country");
		formLayout.addComponent(countryComboBox);
		countryComboBox.setDataProvider(
				new CallbackDataProvider<Country, String>(query -> initDataWrapperDto.getCountries().stream(),
						qyery -> initDataWrapperDto.getCountries().size()));
		countryComboBox.setRequiredIndicatorVisible(true);
		binder.forField(countryComboBox).withValidator(new RequiredValidator()).bind(Address::getCountry, Address::setCountry);
		
		final CheckBox residentialAddressCheckBox = new CheckBox("Residential Address");
		formLayout.addComponent(residentialAddressCheckBox);
		binder.bind(residentialAddressCheckBox, Address::isResidentialFlag, Address::setResidentialFlag);

		final CheckBox defaultAddress = new CheckBox("Default Address");
		formLayout.addComponent(defaultAddress);
		addressPanel.setContent(formLayout);
		binder.bind(defaultAddress, Address::isDefaultFlag, Address::setDefaultFlag);
		binder.setBean(address);
		
		setOkButtonClickListener(event -> {
			if(!binder.validate().isOk()) {
				Notification.show("Input data is not valid", Type.ERROR_MESSAGE);
				return;
			}
			saveEntityListener.save(binder.getBean(), getOperationType());
			binder.setBean(saveEntityListener.getBean(getOperationType()));
			addressTypeComboBox.focus();
			if(OPER_TYPE.EDIT == getOperationType()) {
				close();
			}
		});
	}

	private void buildContactLayout(final AddressInitDataWrapperDto initDataWrapperDto, final VerticalLayout layout) {
		final Panel contactPanel = new Panel("Contact List");
		layout.addComponent(contactPanel);
		contactPanel.setHeight(200.0f, Unit.PIXELS);

		final VerticalLayout root = new VerticalLayout();
		contactPanel.setContent(root);
		root.setSizeFull();
		root.setMargin(false);
		root.setSpacing(false);

		final MenuBar menuBar = new MenuBar();
		root.addComponent(menuBar);
		menuBar.setSizeUndefined();
		menuBar.setWidth(100, Unit.PERCENTAGE);
		menuBar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menuBar.addStyleName(ValoTheme.MENUBAR_SMALL);
		menuBar.addItem("", VaadinIcons.FILE_ADD, event -> {

			ContactAddNewView addNewView = new ContactAddNewView(this, initDataWrapperDto.getContactTypes());
			addNewView.initView();
			UI.getCurrent().addWindow(addNewView);

		});
		menuBar.addItem("", VaadinIcons.EDIT, event -> {

			if (contactGrid.asSingleSelect().isEmpty()) {
				Notification.show("No contact is selected", Type.WARNING_MESSAGE);
				return;
			}

			ContactAddNewView addNewView = new ContactAddNewView(this, OPER_TYPE.EDIT,
					initDataWrapperDto.getContactTypes());
			addNewView.initView();
			UI.getCurrent().addWindow(addNewView);
		});
		menuBar.addItem("", VaadinIcons.FILE_REMOVE, event -> {
			if (contactGrid.asSingleSelect().isEmpty()) {
				Notification.show("No contact is selected", Type.WARNING_MESSAGE);
				return;
			}
			ConfirmDialog.showDialog("Are you sure to delete?", new ClickListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					address.getContacts().remove(contactGrid.asSingleSelect().getValue());
					contactGrid.getDataProvider().refreshAll();
				}
			});

		});

		root.addComponent(contactGrid);
		root.setExpandRatio(contactGrid, 1);
		contactGrid.addColumn(Contact::getName).setCaption("Name");
		contactGrid.addColumn(Contact::getContact).setCaption("Value");
		contactGrid.addColumn(Contact::getType).setCaption("Contact Type");
		contactGrid.addColumn(Contact::isDefaultFlag).setCaption("Default");
		contactGrid.setSizeFull();
		contactGrid.addStyleName(ValoTheme.TABLE_SMALL);
		contactGrid.setSelectionMode(SelectionMode.SINGLE);
		contactGrid.setDataProvider(new CallbackDataProvider<>(query -> address.getContacts().stream(),
				query -> address.getContacts().size()));

	}

	@Override
	public void save(Contact bean, OPER_TYPE type) {
		if (OPER_TYPE.ADD == type) {
			address.getContacts().add(bean);
			contactGrid.getDataProvider().refreshAll();
		} else {
			contactGrid.getDataProvider().refreshItem(bean);
		}
	}

	@Override
	public Contact getBean(OPER_TYPE type) {
		if (OPER_TYPE.ADD == type) {
			return new Contact();
		}
		return contactGrid.asSingleSelect().getValue();
	}

}
