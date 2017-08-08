package com.belms.dream.workspace.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.vaadin.data.Binder;
import com.vaadin.shared.ui.MarginInfo;
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
	
	public PartGeneral(final PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<Part>();
//		addStyleName("profile-form");
//		setIcon(VaadinIcons.USER);
		setCaption("General");
		
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);

		final TextField nameTextField = new TextField("Name");
		
		binder.bind(nameTextField, Part::getName, Part::setName);
//		nameTextField.setRequiredIndicatorVisible(true);

		formLayout.addComponent(nameTextField);
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
