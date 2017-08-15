package com.belms.dream.workspace.part.windows;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.mainview.FilterListener;
import com.belms.dream.workspace.common.mainview.ShowSlectedItemListener;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.common.newview.StepView;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;

public class NewPartViewImpl extends AbstractNewView<Part> implements INewPartView  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewPartViewImpl(EventBusProvider eventBusProvider) {
		super(eventBusProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setItemListData(List<Part> itemList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData(Part data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFilterListener(FilterListener filterListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShowItemListener(ShowSlectedItemListener<Part> showSlectedItemListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSaveEntityListener(SaveEnityListener<Part> saveEnityListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRefreshEntityListener(RefreshEntityListener<Part> refreshEntityListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDataInitWrapper(PartInitDataWrapperDto data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PartInitDataWrapperDto getDataInitWrapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventBusProvider getEventBusProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNew(Part t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Part getNewItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<StepView<Part>> getStepViews() {
		// TODO Auto-generated method stub
		return null;
	}

}
