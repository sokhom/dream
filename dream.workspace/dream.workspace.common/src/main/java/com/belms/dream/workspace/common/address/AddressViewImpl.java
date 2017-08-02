/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.address;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.common.address.newview.AddressAddNewView;
import com.belms.dream.workspace.common.dialog.ConfirmDialog;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.address.AddressType;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.contact.Contact;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.SerializableFunction;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AddressViewImpl extends VerticalLayout implements AddressView, SaveEntityListener<Address> {

	private static final long serialVersionUID = 1L;
	private final ListSelect<Address> addressListSelect = new ListSelect<>();
	private DataProvider<Address, String> dataProvider;
	private DataProvider<Contact, String> contactDataProvider;
	private final Binder<Address> binder = new Binder<>();
	private AddressInitDataWrapperDto addressInitDataWrapperDto;
	private List<Address> addresses = new ArrayList<>();
	private float contactListHeight = 150.0f;
	
	
	public AddressViewImpl(AddressInitDataWrapperDto addressInitDataWrapperDto) {
		setInitDataWrapperDto(addressInitDataWrapperDto);
	}

	private void buildUI() {
		setCaption("Address");
		setIcon(VaadinIcons.WORKPLACE);
		setSizeFull();
		setMargin(false);
		HorizontalLayout root = new HorizontalLayout();
		root.setMargin(false);
		root.setSpacing(false);
		root.setSizeFull();
		root.addStyleName("profile-form");

		VerticalLayout layoutDetail = new VerticalLayout();
		layoutDetail.setSizeFull();
		layoutDetail.setMargin(false);
		layoutDetail.setSpacing(false);

		buildAddressDetail(layoutDetail);
		buildContactList(layoutDetail);
		root.addComponent(layoutDetail);
		root.setExpandRatio(layoutDetail, 1);
		buildAddressList(root);
		addComponent(root);
	
		
	}

	private void buildAddressList(HorizontalLayout parent) {
		Panel panel = new Panel();

		parent.addComponent(panel);
		panel.setCaption("Addresss List");
		panel.setIcon(VaadinIcons.LIST);
		panel.setWidth(200.0f, Unit.PIXELS);
		panel.setHeight(100.0f, Unit.PERCENTAGE);

		final VerticalLayout layout = new VerticalLayout();
		panel.setContent(layout);
		layout.setSizeFull();
		layout.setMargin(false);
		layout.setSpacing(false);

		final MenuBar menuBar = new MenuBar();
		menuBar.setWidth(100, Unit.PERCENTAGE);
		menuBar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menuBar.addStyleName(ValoTheme.MENUBAR_SMALL);
		menuBar.addItem("", VaadinIcons.FILE_ADD, event -> {

			AddressAddNewView addNewView = new AddressAddNewView(this, OPER_TYPE.ADD, addressInitDataWrapperDto);
			addNewView.initView();

			UI.getCurrent().addWindow(addNewView);
		});
		menuBar.addItem("", VaadinIcons.EDIT, event->{
			if(addressListSelect.getSelectedItems().isEmpty()) {
				Notification.show("No contact is selected to be edited.", Type.WARNING_MESSAGE);
				return;
			}
			
			AddressAddNewView addNewView = new AddressAddNewView(this, OPER_TYPE.EDIT, addressInitDataWrapperDto);
			addNewView.initView();

			UI.getCurrent().addWindow(addNewView);
		});
		menuBar.addItem("", VaadinIcons.FILE_REMOVE, event->{
			if(addressListSelect.getSelectedItems().isEmpty()) {
				Notification.show("No contact is selected to be edited.", Type.WARNING_MESSAGE);
				return;
			}
			ConfirmDialog.showDialog("Are you sure to delete?", new ClickListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent arg0) {
					addresses.removeAll(addressListSelect.getSelectedItems());
				}
			});
		});
		layout.addComponent(menuBar);

		
		layout.addComponent(addressListSelect);
		layout.setExpandRatio(addressListSelect, 1);
		
		addressListSelect.setSizeFull();
		
		dataProvider = new CallbackDataProvider<Address, String>(query -> this.addresses.stream(),
				query -> this.addresses.size());
		addressListSelect.setDataProvider(dataProvider);
		
		addressListSelect.addSelectionListener(event -> {
			if (event.getFirstSelectedItem().isPresent()) {
				binder.setBean(event.getFirstSelectedItem().get());
				contactDataProvider.refreshAll();
			} else {
				binder.setBean(getBean(OPER_TYPE.ADD));
				contactDataProvider.refreshAll();
			}
		});
		
	}

	private void buildAddressDetail(VerticalLayout parent) {
		Panel layout = new Panel();
		parent.addComponent(layout);
		layout.setIcon(VaadinIcons.BUILDING);
		layout.setCaption("Address Info");
		layout.setSizeFull();
		parent.setExpandRatio(layout, 1);

		layout.setSizeFull();

		FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);

		final TextField addressTypeTextField = new TextField("Address Type");
		formLayout.addComponent(addressTypeTextField);
		binder.forField(addressTypeTextField).withConverter(null, new SerializableFunction<AddressType, String>() {
			private static final long serialVersionUID = 1L;
			@Override
			public String apply(AddressType t) {
				
				return t==null? "": t.toString();
			}
		}).bind(Address::getType, null);
		addressTypeTextField.setReadOnly(true);

		final TextField nameTextField = new TextField("Address Name");
		formLayout.addComponent(nameTextField);
		binder.bind(nameTextField, Address::getName, null);
		nameTextField.setReadOnly(true);

		final TextArea addressTextArea = new TextArea("Address");
		formLayout.addComponent(addressTextArea);
		addressTextArea.setRows(2);
		binder.bind(addressTextArea, Address::getAddress,null);
		addressTextArea.setReadOnly(true);

		final HorizontalLayout wrap = new HorizontalLayout();
		formLayout.addComponent(wrap);
		wrap.setSpacing(false);
		wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		wrap.setCaption("City/State/Zip");

		final TextField cityTextField = new TextField();
		wrap.addComponent(cityTextField);
		cityTextField.setWidth(100, Unit.PIXELS);
		cityTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		binder.bind(cityTextField, Address::getCity, Address::setCity);
		cityTextField.setReadOnly(true);
		wrap.addComponent(new Label("/"));
		
		final TextField stateTextField = new TextField();
		wrap.addComponent(stateTextField);
		stateTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		stateTextField.setWidth(100, Unit.PIXELS);
		binder.forField(stateTextField).withConverter(null, new SerializableFunction<State, String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String apply(State t) {
				return  t==null?"" : t.toString();
			}
		}).bind(Address::getState, null);
		stateTextField.setReadOnly(true);
		wrap.addComponent(new Label("/"));

		final TextField zipTextField = new TextField();
		zipTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		zipTextField.setWidth(100, Unit.PIXELS);
		zipTextField.setReadOnly(true);
		binder.bind(zipTextField, Address::getZip, null);
		
		
		wrap.addComponent(zipTextField);

		final TextField countryTextField = new TextField("Country");
		formLayout.addComponent(countryTextField);
		countryTextField.setReadOnly(true);
		binder.forField(countryTextField).withConverter(null, new SerializableFunction<Country, String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String apply(Country t) {
				return t==null?"" :t.toString();
			}
		}).bind(Address::getCountry, null);

		final CheckBox residentialAddressCheckBox = new CheckBox("Residential Address");
		formLayout.addComponent(residentialAddressCheckBox);
		residentialAddressCheckBox.setReadOnly(true);
		binder.bind(residentialAddressCheckBox, Address::isResidentialFlag,null);

		final CheckBox defaultAddress = new CheckBox("Default Address");
		formLayout.addComponent(defaultAddress);
		defaultAddress.setReadOnly(true);
		binder.bind(defaultAddress, Address::isDefaultFlag,null);
		layout.setContent(formLayout);
	}

	private void buildContactList(VerticalLayout parent) {
		final Panel layout = new Panel();
		layout.setHeight(contactListHeight, Unit.PIXELS);
		layout.setIcon(VaadinIcons.GROUP);
		layout.setCaption("Contact List");
		parent.addComponent(layout);

		final Grid<Contact> contactGrid = new Grid<>();
		layout.setContent(contactGrid);
		contactGrid.addStyleName(ValoTheme.TABLE_SMALL);
		contactGrid.addColumn(Contact::getName).setCaption("Name");
		contactGrid.addColumn(Contact::getContact).setCaption("Value");
		contactGrid.addColumn(Contact::getType).setCaption("Contact Type");
		contactGrid.addColumn(Contact::isDefaultFlag).setCaption("Default");
		contactGrid.setSizeFull();
		contactGrid.setSelectionMode(SelectionMode.SINGLE);
		contactDataProvider =new CallbackDataProvider<Contact, String>(query-> {
			
			if(binder.getBean()==null) {
				return (new ArrayList<Contact>()).stream();
			}else {
				return binder.getBean().getContacts().stream();		
			}
		
		}, query->{
			if(binder.getBean()==null){
				return 0;
			}
			return binder.getBean().getContacts().size();	
		});
		contactGrid.setDataProvider(contactDataProvider);
	}


	
	private void refresh() {
		dataProvider.refreshAll();
		contactDataProvider.refreshAll();
	}
	
	@Override
	public void initView() {
		buildUI();
	}

	@Override
	public void setInitDataWrapperDto(final AddressInitDataWrapperDto addressInitDataWrapperDto) {
		this.addressInitDataWrapperDto = addressInitDataWrapperDto;

	}

	@Override
	public void save(Address bean, OPER_TYPE type) {
		if (OPER_TYPE.ADD == type) {
			this.addresses.add(bean);
		}
		addressListSelect.deselectAll();
		addressListSelect.select(bean);
		refresh();

	}

	@Override
	public Address getBean(OPER_TYPE type) {
		if (OPER_TYPE.ADD == type) {
			return new Address();
		}
		return binder.getBean();
	}

	@Override
	public void setContactHeight(float height) {
		contactListHeight = height;
		
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Component getView() {
		return this;
	}

	@Override
	public void loadData(List<Address> data) {
		this.addresses = data;
		if(!addresses.isEmpty()) {
			addressListSelect.clear();
			addressListSelect.select(addresses.get(0));	
		}else {
			binder.setBean(new Address());
		}

		refresh();
	}

}
