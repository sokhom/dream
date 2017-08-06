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
	}

	@Override
	public Window getNewView() {
		return null;
	}

}
