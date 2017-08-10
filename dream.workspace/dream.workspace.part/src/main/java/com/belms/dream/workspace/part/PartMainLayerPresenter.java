<<<<<<< HEAD
package com.belms.dream.workspace.part;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.part.IPartService;
import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.mainview.FilterListener;
import com.belms.dream.workspace.common.mainview.ShowSlectedItemListener;
import com.blems.dream.api.model.part.Part;

public class PartMainLayerPresenter implements FilterListener,ShowSlectedItemListener<Part>,AddnewEntityListener<Part>,SaveEnityListener<Part>,RefreshEntityListener<Part> {

	private IPartView partView;
	private IPartService partService;
	public PartMainLayerPresenter(IPartView partView) {
		ServiceFactory factory = ServiceProvider.get(IPartService.ID);
		partService = (IPartService) factory.getService();
		this.partView = partView;
		initData();
		this.partView.initView();
		
	}
	@Override
	public void actionPerformed(String value) {

	}
	@Override
	public void itemSelected(Part selectedITem) {
		partView.loadData(partService.getById(selectedITem.getId()));
		
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
	private void initData() {		
		this.partView.setItemListData(partService.getAll());
		this.partView.setDataInitWrapper(partService.getInitData());
		
		
	}

}
=======
package com.belms.dream.workspace.part;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.part.IPartService;
import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.mainview.FilterListener;
import com.belms.dream.workspace.common.mainview.ShowSlectedItemListener;
import com.blems.dream.api.model.part.Part;

public class PartMainLayerPresenter implements FilterListener,ShowSlectedItemListener<Part>,AddnewEntityListener<Part>,SaveEnityListener<Part>,RefreshEntityListener<Part> {

	private IPartView partView;
	private IPartService partService;
	public PartMainLayerPresenter(IPartView partView) {
		ServiceFactory factory = ServiceProvider.get(IPartService.ID);
		partService = (IPartService) factory.getService();
		this.partView = partView;
		initData();
		this.partView.initView();
		
	}
	@Override
	public void actionPerformed(String value) {

	}
	@Override
	public void itemSelected(Part selectedITem) {
		partView.loadData(partService.getById(selectedITem.getId()));
		
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
	private void initData() {		
		this.partView.setItemListData(partService.getAll());
		this.partView.setDataInitWrapper(partService.getInitData());
		
		
	}

}
>>>>>>> refs/remotes/origin/master
