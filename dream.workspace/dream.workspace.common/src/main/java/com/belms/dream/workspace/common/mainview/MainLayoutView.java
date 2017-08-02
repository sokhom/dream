/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.mainview;

import java.util.List;

import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.View;
import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.ui.FilterItemList;

public interface MainLayoutView<T extends FilterItemList, E extends DefaultModel, W> extends View{
	
	void setItemListData(List<T> itemList);
	void loadData(E data);
	void setFilterListener(FilterListener filterListener);
	void setShowItemListener(ShowSlectedItemListener<T> showSlectedItemListener);
	
	void setSaveEntityListener(SaveEnityListener<E> saveEnityListener);
	void setRefreshEntityListener(RefreshEntityListener<E> refreshEntityListener);
	
	void setDataInitWrapper(W data);
	W getDataInitWrapper();
	EventBusProvider getEventBusProvider();
	
	void addNew(T t);
	
	
	
}
