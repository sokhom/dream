package com.belms.dream.workspace.part;

import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.mainview.FilterListener;
import com.belms.dream.workspace.common.mainview.ShowSlectedItemListener;
import com.blems.dream.api.model.part.Part;

public class PartMainLayerPresenter implements FilterListener,ShowSlectedItemListener<Part>,AddnewEntityListener<Part>,SaveEnityListener<Part>,RefreshEntityListener<Part> {

	private IPartView partView;
	
	public PartMainLayerPresenter(IPartView partView) {
		this.partView = partView;
		this.partView.initView();
	}
	@Override
	public void actionPerformed(String value) {

	}
	@Override
	public void itemSelected(Part selectedITem) {
		
		
	}
	@Override
	public Part refresh(Part entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Part entiry) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addNew(Part t) {
		// TODO Auto-generated method stub
		
	}
	

}
