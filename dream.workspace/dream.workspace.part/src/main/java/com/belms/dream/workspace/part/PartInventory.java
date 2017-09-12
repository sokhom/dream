package com.belms.dream.workspace.part;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.product.Product;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PartInventory extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PartInventory(PartInitDataWrapperDto partInitDataWrapperDto) {
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Inventory");
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
		
		final ComboBox< Account> abcCodeComb = new ComboBox<>("ABC Code");
		formLayout.addComponent(abcCodeComb);
		
		final ComboBox< Account> uomComb = new ComboBox<>("Unit of Measure");
		formLayout.addComponent(uomComb);
		
		final FormLayout hLayoutInventory = new FormLayout();
		hLayoutInventory.setCaption("Inventory");
		formLayout.addComponent(hLayoutInventory);
		
		final TextField onHandText = new TextField("On Hand");
		onHandText.setReadOnly(true);
		hLayoutInventory.addComponent(onHandText);
		
		final TextField onOrder = new TextField("On Order");
		onOrder.setReadOnly(true);
		hLayoutInventory.addComponent(onOrder);		
	
		final TextField allocated = new TextField("Allocated");
		allocated.setReadOnly(true);
		hLayoutInventory.addComponent(allocated);
		
		final TextField committedText = new TextField("Committed");
		committedText.setReadOnly(true);
		hLayoutInventory.addComponent(committedText);
		
		final TextField notAvailableText = new TextField("Not Available");
		notAvailableText.setReadOnly(true);
		hLayoutInventory.addComponent(notAvailableText);
		
		final TextField backOrderText = new TextField("Back Order");
		backOrderText.setReadOnly(true);
		hLayoutInventory.addComponent(backOrderText);
		
		final TextField dropShipText = new TextField("Drop Ship");
		dropShipText.setReadOnly(true);
		hLayoutInventory.addComponent(dropShipText);
		
		final TextField availableForSaleText = new TextField("Available For Sale");
		availableForSaleText.setReadOnly(true);
		hLayoutInventory.addComponent(availableForSaleText);
		
		final TextField availableToPickUpText = new TextField("Available To Pick Up");
		availableToPickUpText.setReadOnly(true);
		hLayoutInventory.addComponent(availableToPickUpText);
		
		formLayout.addComponent(getHLayout());
		formLayout.setSizeFull();
	}
	
	private HorizontalLayout getHLayout(){
		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setSizeFull();
		hLayout.setCaption("Reorder Information");
		Grid<Product> g = new Grid<Product>();
	      g.setSizeFull();
		List<Product> itemList = new ArrayList<Product>();
		g.setDataProvider(new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size()));
		g.addColumn(Product::getName).setCaption("Location Group");
		g.addColumn(Product::getName).setCaption("Order Up to Level");
		g.addColumn(Product::getName).setCaption("Reorder Point");
//		g.setWidth(100, Unit.PERCENTAGE);
		hLayout.addComponent(g);
		VerticalLayout vLayout = getVButtonCRUDBar();
		vLayout.setWidth(10, Unit.PIXELS);
		hLayout.addComponent(vLayout);
		
		return hLayout;
	}
	
	private VerticalLayout getVButtonCRUDBar(){
		VerticalLayout vLayout = new VerticalLayout();		
		Button btnAdd = new Button(VaadinIcons.ADD_DOCK);
		Button btnEdit = new Button(VaadinIcons.EDIT);
		Button btnDelete = new Button(VaadinIcons.DEL);
		btnAdd.addClickListener(event -> {
			event.getButton();
			System.out.println("Click on add button");			
		});
		btnEdit.addClickListener(event -> {
			event.getButton();
			System.out.println("Click on edit button");			
		});
		btnDelete.addClickListener(event -> {
			event.getButton();
			System.out.println("Click on delete button");			
		});
		
		vLayout.addComponent(btnAdd);
		vLayout.addComponent(btnEdit);
		vLayout.addComponent(btnDelete);
		vLayout.setMargin(true);
		vLayout.setMargin(new MarginInfo(true, true));
		return vLayout;
	}

}
