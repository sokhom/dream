package com.belms.dream.workspace.part.windows;

import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.blems.dream.api.model.product.Product;
import com.vaadin.ui.VerticalLayout;

public class PartProductWindow extends AbstractSimpleDialog implements SaveEntityListener<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void save(Product bean, com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getBean(com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDialogCaption() {
		// TODO Auto-generated method stub
		return "Product";
	}

	@Override
	protected void buildContentLayout(VerticalLayout parent) {
		// TODO Auto-generated method stub
		
	}

}
