package com.belms.dream.workspace.part;

import java.util.ArrayList;
import java.util.List;

//import org.vaadin.grid.cellrenderers.editoraware.CheckboxRenderer;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.product.Product;
import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.event.LayoutEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class PartDetail extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Binder<Part> binder;
	private final Grid<PartToTracking> trackingGrid;
	
	private DataProvider<PartToTracking, String> searchListDataProvider;
	
	public PartDetail(PartInitDataWrapperDto partInitDataWrapper) {
		binder = new Binder<>();
		trackingGrid = getTrackingGrid();
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Detail");
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
		List<PartToTracking> itemList = data.getPartToTrackings();
		searchListDataProvider = new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size());
		trackingGrid.setDataProvider(searchListDataProvider);
		
	}
	private void initUI(){
		
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
	
		final TextField revisionText = new TextField("Revision");		
//		binder.bind(nameTextField, Part::getName, Part::setName);
		formLayout.addComponent(revisionText);
		
		final TextField createdDate = new TextField("Created Date");		
//		binder.bind(nameTextField, Part::getName, Part::setName);
		formLayout.addComponent(createdDate);
		
		
		formLayout.addComponent(trackingGrid);
		formLayout.addComponent(getHLayout());
		
	}
	
	private Grid<PartToTracking> getTrackingGrid(){
		Grid<PartToTracking> grid = new Grid<PartToTracking>("Tracking");	

		// switch to multiselect mode
		grid.setSelectionMode(SelectionMode.MULTI);
		
		
		grid.setColumnReorderingAllowed(true);
		ValueProvider<PartToTracking, String> partTrackingProvider = source -> source.getPartTracking().getName();
		grid.addColumn(partTrackingProvider).setCaption("Name");
		grid.addColumn(source -> source.getPartTracking().getType().getName()).setCaption("Abbr");
		grid.addColumn(source -> source.getPartTracking().getAbbr()).setCaption("Type");
		grid.addColumn(PartToTracking::getNextValue).setCaption("NextValue");
//		grid.addColumn(new ValueProvider<PartToTracking, Boolean>() {
//			@Override
//			public Boolean apply(PartToTracking source) {				
//				return source.isPrimaryFlag();
//			}
//		}).setCaption("Primary");
		
//		grid.addColumn("Primary", new CheckboxRenderer());
		
		grid.asMultiSelect().addSelectionListener(event -> {	
			event.getAllSelectedItems();
			System.out.println("Hello");
		});
		
		return grid;
	}
	private GridLayout getHLayout(){
		GridLayout hLayout = new GridLayout(2,1);
		hLayout.setCaption("Products");
		Grid<Product> g = new Grid<Product>();
		List<Product> itemList = new ArrayList<Product>();
		g.setDataProvider(new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size()));
		g.addColumn(Product::getName).setCaption("Number");
		g.addColumn(Product::getName).setCaption("Number");
		g.addColumn(Product::getName).setCaption("Number");
		g.setWidth(80, Unit.PERCENTAGE);
		hLayout.addComponent(g);
		VerticalLayout vLayout = getVButtonCRUDBar();
		vLayout.setWidth(20, Unit.PERCENTAGE);
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
		
		return vLayout;
	}

}
