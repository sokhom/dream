package com.belms.dream.workspace.part.comps;

import javax.xml.soap.Text;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.product.Product;
import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Setter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ProductView extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Binder<Product> binder;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	
	public ProductView(PartInitDataWrapperDto partInitDataWrapperDto) {
		binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Product");
		
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);

		final TextField nameTextField = new TextField("Number");
//		ValueProvider<Part, String> getPName = source -> source.getDefaultProduct().getName();
//		Setter<Part, String> setPName = new Setter<Part, String>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void accept(Part bean, String fieldvalue) {
//				bean.getDefaultProduct().setName(fieldvalue);
//				
//			}			
//		};
		
		binder.forField(nameTextField).bind(Product::getName ,Product::setName);
		formLayout.addComponent(nameTextField);
		
		final TextField descText = new TextField("Description");
		binder.bind(descText, Product::getDescription,Product::setDescription);
		formLayout.addComponent(descText);
		
		final TextField upcText = new TextField("UPC");
		binder.bind(upcText, Product::getUpc,Product::setUpc);
		formLayout.addComponent(upcText);
		
		final TextField priceText = new TextField("Price");
		binder.bind(priceText, Product::getUpc,Product::setUpc);
		formLayout.addComponent(priceText);
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
		binder.setBean(data.getDefaultProduct());
	}

}
