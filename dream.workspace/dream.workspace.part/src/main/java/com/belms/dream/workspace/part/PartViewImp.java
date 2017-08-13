package com.belms.dream.workspace.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.mainview.AbstractMainView;
import com.blems.dream.api.model.part.Part;
import com.vaadin.ui.Window;

public class PartViewImp extends AbstractMainView<Part, Part, PartInitDataWrapperDto> implements IPartView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartMainLayerPresenter partMainlayerPresenter;
	private EntryView<Part> partDetail;
	private EntryView<Part> partAccount;
	private EntryView<Part> partInventory;
	private EntryView<Part> partLocation;
	private EntryView<Part> partMemo;
	private EntryView<Part> partVendors;
	public PartViewImp(EventBusProvider eventBusProvider) {
		super(eventBusProvider);
		PartMainLayerPresenter partMainlayerPresenter = new PartMainLayerPresenter(this);
		this.setFilterListener(partMainlayerPresenter);
		this.setShowItemListener(partMainlayerPresenter);
		this.setSaveEntityListener(partMainlayerPresenter);
		this.setRefreshEntityListener(partMainlayerPresenter);
		
	}
	
	@Override
	public void initView() {
		super.initView();
		EntryView<Part> entryView = new PartGeneral(getDataInitWrapper());		
		addTab(entryView);
		partDetail = new PartDetail(getDataInitWrapper());
		addTab(partDetail);
		partAccount = new PartAccounts(getDataInitWrapper());
		addTab(partAccount);
		partInventory = new PartInventory(getDataInitWrapper());
		addTab(partInventory);
		partLocation = new PartLocation(getDataInitWrapper());
		addTab(partLocation);
		partMemo = new PartMemo(getDataInitWrapper());
		addTab(partMemo);
		partVendors = new PartVendors(getDataInitWrapper());
		addTab(partVendors);
	}
	

	@Override
	public Window getNewView() {
		return null;
	}

}
