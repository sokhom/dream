/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.mainview;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.view.EntryView;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.dialog.ConfirmDialog;
import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.ui.FilterItemList;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractMainView<T extends FilterItemList, E extends DefaultModel, W> extends Panel
		implements MainLayoutView<T, E, W> {

	private OPER_TYPE operType =OPER_TYPE.VIEW;
	private static final long serialVersionUID = 1L;
	private FilterListener filterListener;
	private ShowSlectedItemListener<T> showSlectedItemListener;
	
	private SaveEnityListener<E> saveEnityListener;
	private RefreshEntityListener<E> refreshEntityListener;
	
	private List<T> itemList = new ArrayList<>();
	private W dataInitWrapperDto;
	private final EventBusProvider eventBusProvider;
	private final TabSheet tabsheet = new TabSheet();
	private DataProvider<T, String> searchListDataProvider;
	private final List<EntryView<E>> entryViews = new ArrayList<>();
	private E data;
	

	public AbstractMainView(final EventBusProvider eventBusProvider) {
		this.eventBusProvider = eventBusProvider;
	}

	@Override
	public EventBusProvider getEventBusProvider() {
		return eventBusProvider;
	}

	
	protected void setOperType(OPER_TYPE type) {
		this.operType = type;
	}
	
	public abstract Window getNewView();

	@Override
	public void initView() {
		final VerticalLayout mainViewArea = new VerticalLayout();

		mainViewArea.setMargin(false);
		mainViewArea.setSpacing(false);
		mainViewArea.setSizeFull();
		mainViewArea.addComponent(buildMenuber());
		buildViewArea(mainViewArea);
	
		final HorizontalSplitPanel splitPanel = new HorizontalSplitPanel(buildItemListLayout(), mainViewArea);
		setContent(splitPanel);
		splitPanel.setSizeFull();
		splitPanel.setSplitPosition(200, Unit.PIXELS);
		splitPanel.setMinSplitPosition(100, Unit.PIXELS);
		splitPanel.setMaxSplitPosition(600, Unit.PIXELS);
		setSizeFull();

	}

	private Component buildMenuber() {

		final MenuBar menubar = new MenuBar();
		menubar.setWidth(100.0f, Unit.PERCENTAGE);
		menubar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menubar.addItem("New", VaadinIcons.FILE_ADD, selectedItem-> UI.getCurrent().addWindow(getNewView()));
		final MenuItem editItem = menubar.addItem("Edit", VaadinIcons.EDIT, null);
		final MenuItem saveItem = menubar.addItem("Save", VaadinIcons.CHECK, null);
		saveItem.setEnabled(false);
		final MenuItem cancelItem = menubar.addItem("Cancel", VaadinIcons.FILE_REMOVE, null);
		cancelItem.setEnabled(false);
		
		
		
		Command command = new Command() {
		
			private static final long serialVersionUID = 1L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				if(data==null) {
					return;
				}
				if(editItem.equals(selectedItem)) {
					if(OPER_TYPE.VIEW == operType ) {
						setOperType(OPER_TYPE.EDIT);
						saveItem.setEnabled(true);
						cancelItem.setEnabled(true);
						editItem.setEnabled(false);	
					}
					
				}else if(saveItem.equals(selectedItem)) {
					if(OPER_TYPE.EDIT == operType) {
						
						for (EntryView<E> entryView : entryViews) {
							if(!entryView.isValid()) {
								tabsheet.setSelectedTab(entryView.getView());
								Notification.show("Input Data is not valid.", Type.ERROR_MESSAGE);
								return;
							}
						}
						
						ConfirmDialog.showDialog("Are you sure to save?", new ClickListener() {
						
							private static final long serialVersionUID = 1L;

							@Override
							public void buttonClick(ClickEvent event) {
								try {
									saveEnityListener.save(data);
									
									saveItem.setEnabled(false);
									cancelItem.setEnabled(false);
									editItem.setEnabled(true);
									Notification.show("Saved sucessfully", Type.HUMANIZED_MESSAGE);
								}catch (Exception e) {
									Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
								}
							}
						});
						
						setOperType(OPER_TYPE.VIEW);
						
						
					}
				}else if(cancelItem .equals(selectedItem)) {
					loadData(refreshEntityListener.refresh(data));
					tabsheet.setSelectedTab(0);
					setOperType(OPER_TYPE.VIEW);
					saveItem.setEnabled(false);
					cancelItem.setEnabled(false);
					editItem.setEnabled(true);
				}
					
			}
		};
		
		editItem.setCommand(command);
		saveItem.setCommand(command);
		cancelItem.setCommand(command);
	
		return menubar;
	}

	protected void buildViewArea(final VerticalLayout mainViewArea) {
		
		final VerticalLayout layout = new VerticalLayout();
		mainViewArea.addComponent(layout);
		mainViewArea.setExpandRatio(layout, 1);
		layout.setSizeFull();
		layout.setMargin(false);
		layout.setSpacing(false);
		tabsheet.setSizeFull();
		tabsheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
		layout.addComponent(tabsheet);
	
	}
	
	protected void addTab(EntryView<E> view) {
		entryViews.add(view);
		tabsheet.addComponent(view.getView());
	}
	
	protected void addTab(Component view) {
		tabsheet.addComponent(view);
	}

	private Component buildItemListLayout() {
		VerticalLayout itemListLayout = new VerticalLayout();
		final Component itemList = buildItemList();
		itemListLayout.addStyleName("itemlist");
		itemListLayout.setMargin(false);
		itemListLayout.setSpacing(false);
		itemListLayout.addComponent(buildFilterLayout());
		itemListLayout.addComponent(itemList);
		itemListLayout.setExpandRatio(itemList, 1);
		itemListLayout.setSizeFull();
		itemList.setSizeFull();
		return itemListLayout;
	}

	private Component buildFilterLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(false);
		horizontalLayout.setSpacing(false);
		horizontalLayout.setWidth(100, Unit.PERCENTAGE);
		final Component component = buildFilter();
		horizontalLayout.addComponent(component);
		horizontalLayout.addComponent(buildAdvanceSearch());
		horizontalLayout.setExpandRatio(component, 1);
		return horizontalLayout;
	}

	private Component buildAdvanceSearch() {

		final Button button = new Button(VaadinIcons.ELLIPSIS_CIRCLE_O);
		return button;
	}

	@SuppressWarnings("serial")
	private Component buildFilter() {
		final TextField filter = new TextField();
		filter.setPlaceholder("Filter");
		filter.setIcon(VaadinIcons.SEARCH);
		filter.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		filter.setWidth(100, Unit.PERCENTAGE);
		filter.addShortcutListener(new ShortcutListener("Clear", KeyCode.ESCAPE, null) {
			@Override
			public void handleAction(final Object sender, final Object target) {
				filter.setValue("");
			}
		});
		filter.addValueChangeListener(event -> {
			if (filterListener != null) {
				filterListener.actionPerformed(event.getValue());
			}
		});

		return filter;

	}

	private Component buildItemList() {
		final Grid<T> itemListGrid = new Grid<>();
		itemListGrid.setSizeFull();
		searchListDataProvider = new CallbackDataProvider<>(query -> this.itemList.stream(), query -> this.itemList.size());
		itemListGrid.setDataProvider(searchListDataProvider);

		itemListGrid.setSelectionMode(SelectionMode.SINGLE);
		itemListGrid.addColumn(FilterItemList::getName).setCaption("Name");
		itemListGrid.addColumn(FilterItemList::getDescription).setCaption("Description");
		itemListGrid.addSelectionListener(event -> {
			if (event.getFirstSelectedItem().isPresent()) {
				this.showSlectedItemListener.itemSelected(event.getFirstSelectedItem().get());
			}

		});
		return itemListGrid;
	}

	@Override
	public void setDataInitWrapper(W data) {
		this.dataInitWrapperDto = data;

	}

	@Override
	public W getDataInitWrapper() {

		if (this.dataInitWrapperDto == null) {
			throw new RuntimeException("No init data found.");
		}
		return this.dataInitWrapperDto;
	}

	@Override
	public void loadData(E data) {
		this.data = data;
		for (EntryView<E> entryView : entryViews) {
			entryView.loadData(this.data);
		}

	}

	public void setFilterListener(FilterListener filterListener) {
		this.filterListener = filterListener;
	}

	@Override
	public void setItemListData(List<T> itemList) {
		this.itemList = itemList;

	}

	@Override
	public void setShowItemListener(ShowSlectedItemListener<T> showSlectedItemListener) {
		this.showSlectedItemListener = showSlectedItemListener;

	}
	
	@Override
	public void setSaveEntityListener(SaveEnityListener<E> saveEnityListener) {
		this.saveEnityListener = saveEnityListener;
	}

	@Override
	public void setRefreshEntityListener(RefreshEntityListener<E> refreshEntityListener) {
		this.refreshEntityListener = refreshEntityListener;
		
	}

	@Override
	public void addNew(T t) {
//		this.itemList.add(t);
		searchListDataProvider.refreshAll();
		
		
	}
	
	

}
