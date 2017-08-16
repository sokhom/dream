
package com.belms.dream.workspace.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartType;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.uom.Uom;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PartGeneral extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Binder<Part> binder;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	
	public PartGeneral(final PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<Part>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
//		addStyleName("profile-form");
//		setIcon(VaadinIcons.USER);
		setCaption("General");
		
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);

		final TextField nameTextField = new TextField("Part Number");		
		binder.bind(nameTextField, Part::getName, Part::setName);
//		nameTextField.setRequiredIndicatorVisible(true);

		formLayout.addComponent(nameTextField);
		
		final ComboBox<Uom> uomComb = new ComboBox<Uom>("UOM");		
		binder.forField(uomComb).bind(Part::getUom, null);
		formLayout.addComponent(uomComb);
		
		final ComboBox<PartType> partTypeComb = new ComboBox<PartType>("Type");		
		binder.forField(partTypeComb).bind(Part::getPartType, Part::setPartType);
		partTypeComb.setDataProvider(new CallbackDataProvider<PartType,String>(query->partInitDataWrapperDto.getPartTypes().stream(),query->partInitDataWrapperDto.getPartTypes().size()));
		formLayout.addComponent(partTypeComb);
		
		final TextField descripText = new TextField("Description");		
		binder.bind(descripText, Part::getDescription, Part::setDescription);
		formLayout.addComponent(descripText);
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

}
