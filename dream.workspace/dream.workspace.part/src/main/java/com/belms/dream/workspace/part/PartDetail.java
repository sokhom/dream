package com.belms.dream.workspace.part;

import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class PartDetail extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Component getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadData(Part data) {
		// TODO Auto-generated method stub
		
	}

}
