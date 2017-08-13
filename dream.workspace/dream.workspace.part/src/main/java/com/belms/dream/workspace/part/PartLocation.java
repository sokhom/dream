package com.belms.dream.workspace.part;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.part.Part;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PartLocation extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Binder<Part> binder;
	private PartInitDataWrapperDto initDataWrapperDto;
	public PartLocation(PartInitDataWrapperDto partInitDataWrapperDto) {
		binder = new Binder<>();
		this.initDataWrapperDto = partInitDataWrapperDto;
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Location");
		initUI();
	}

	@Override
	public boolean isValid() {		
		return false;
	}

	@Override
	public Component getView() {		
		return this;
	}

	@Override
	public void loadData(Part data) {		
		binder.setBean(data);
	}
	private void initUI(){
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
		 List<LocationGroup>  locGroups = initDataWrapperDto.getLocationGroup();
		 
		 for (LocationGroup locG : locGroups) {			 
			 final ComboBox<Location> assetAccount = new ComboBox<>(locG.getName());
//		binder.forField(currencyComboBox).withValidator(new RequiredValidator()).bind(Customer::getCurrency, Customer::setCurrency);
			 assetAccount.setDataProvider(new CallbackDataProvider<Location, String>(query->locG.getLocations().stream(), qyery->locG.getLocations().size()));
			 formLayout.addComponent(assetAccount);			
		}
		
	}

}
