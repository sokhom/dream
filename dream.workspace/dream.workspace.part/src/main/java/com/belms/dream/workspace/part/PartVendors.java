package com.belms.dream.workspace.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.part.Part;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PartVendors extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PartVendors(PartInitDataWrapperDto partInitDataWrapperDto) {
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Vendors");
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
		
	}
	private void initUI(){
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
		
		final ComboBox< Account> assetAccount = new ComboBox<>("Asset Account");
		formLayout.addComponent(assetAccount);
		final ComboBox< Account> cogsAccount = new ComboBox<>("COGS Account");
		formLayout.addComponent(cogsAccount);
		final ComboBox< Account> adjAccount = new ComboBox<>("Adjustment Account");
		formLayout.addComponent(adjAccount);
		final ComboBox< Account> scrapAccount = new ComboBox<>("Scrap Account");
		formLayout.addComponent(scrapAccount);
	}

}
