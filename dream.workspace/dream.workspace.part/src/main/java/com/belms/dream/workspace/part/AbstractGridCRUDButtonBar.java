package com.belms.dream.workspace.part;

import java.util.List;
import java.util.Set;

import com.belms.dream.api.view.EntryView;
import com.belms.dream.workspace.common.dialog.ConfirmDialog;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractGridCRUDButtonBar<T> extends Panel implements EntryView<List<T>> {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grid<T> grid;
    private List<T> itemList;
	
	public AbstractGridCRUDButtonBar() {
		setCaption(getTitle());
		setSizeFull();
		VerticalLayout hLayout = new VerticalLayout();
		hLayout.setSizeFull();
		final MenuBar menuBar = new MenuBar();
		menuBar.setWidth(100, Unit.PERCENTAGE);
		menuBar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menuBar.addStyleName(ValoTheme.MENUBAR_SMALL);

		menuBar.addItem("", VaadinIcons.FILE_ADD, event -> {
			UI.getCurrent().addWindow(getNewView());
		});
		menuBar.addItem("", VaadinIcons.EDIT, event->{
			if(alterNoItemSelected(getNoItemSelectedToBeEditedMsg())){return;};
			UI.getCurrent().addWindow(getEditView());
		});
		menuBar.addItem("", VaadinIcons.FILE_REMOVE, event->{
			if(alterNoItemSelected(getNoItemSelectedToBeDeletedMsg())){return;};
			ConfirmDialog.showDialog("Are you sure to delete?", new ClickListener() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;				
				@Override
				public void buttonClick(ClickEvent event) {		
				 Set<T>	 selectedItems = grid.getSelectedItems();
				 
				    itemList.removeAll(selectedItems);				 
					afterItemDeleted(selectedItems,grid);
					loadDataGrid(itemList);
				}				
			});
		});
		grid = new Grid<T>();
		grid.setSizeFull();
		hLayout.addComponent(menuBar);
		hLayout.addComponent(grid);
		setContent(hLayout);		
		initUI();
	}
	protected abstract String getTitle();	
	protected abstract void initUI();
	protected abstract void afterItemDeleted(Set<T> itemDeleted,Grid<T> grid);
	protected  String getNoItemSelectedToBeEditedMsg(){return "No item is selected to be edite.";}
	protected  String getNoItemSelectedToBeDeletedMsg(){return "No item is selected to be deleted.";}
	protected abstract Window getNewView();
	protected abstract Window getEditView();
	
	protected <V> Column<T, V> addColumn(ValueProvider<T, V> valueProvider) {
	        return grid.addColumn(valueProvider);
	}

	public Component getView(){
		return this;
	}
	
	public void loadData(List<T> data){		
		itemList = data;
		loadDataGrid(itemList);
	}
	private void loadDataGrid(List<T> data){
		DataProvider<T, String> dataProvider = new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size());
		grid.setDataProvider(dataProvider);
	}
	
	private boolean alterNoItemSelected(String text){ 
		if(grid.getSelectedItems().isEmpty()) {
			String msg = text;
			msg = msg.isEmpty()?"No item is selected.":msg;
			Notification.show(msg, Type.WARNING_MESSAGE);
			return true ;
		}
		return false;
	}
	
}
