package com.belms.dream.workspace.part.grid;

import java.util.Set;

import com.belms.dream.workspace.part.AbstractGridCRUDButtonBar;
import com.belms.dream.workspace.part.windows.PartProductWindow;
import com.blems.dream.api.model.product.Product;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Window;

public class ProdutGrid extends AbstractGridCRUDButtonBar<Product> {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProdutGrid() {
		
	}

	
	@Override
	protected void initUI() {
		addColumn(Product::getName).setCaption("Number");
		addColumn(Product::getName).setCaption("Number");
		
	}


	@Override
	protected String getTitle() {		
		return "Products";
	}

	@Override
	public boolean isValid() {
		
		return false;
	}


	@Override
	protected String getNoItemSelectedToBeEditedMsg() {		
		return "No product was selected to be edited.";
	}
	@Override
	protected String getNoItemSelectedToBeDeletedMsg() {		
		return "No product was selected to be deleted.";
	}


	@Override
	protected void afterItemDeleted(Set<Product> itemDeleted, Grid<Product> grid) {		
		
	}


	@Override
	protected Window getNewView() {
		PartProductWindow partPronew = new PartProductWindow();
		partPronew.initView();
		return partPronew;
	}


	@Override
	protected Window getEditView() {
		
		return null;
	}
	

}
