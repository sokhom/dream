package com.belms.dream.workspace.part.comps;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.tag.Tag;
import com.blems.dream.api.model.uom.Uom;
import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.server.Setter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class InitInventoryView extends VerticalLayout  implements EntryView<Tag>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private Binder<Tag> binder;
	private ComboBox<Uom> uomComb;
	public InitInventoryView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		this.binder = new Binder<>();
		
		initUI();
	}

	@Override
	public boolean isValid() {
		
		return true;
	}

	@Override
	public Component getView() {
		
		return this;
	}

	@Override
	public void loadData(Tag data) {		
		this.binder.setBean(data);
		binder.forField(uomComb).bind(source->source.getPart().getUom(),(bean, uom) -> bean.getPart().setUom(uom) );
	}
	
	private void initUI(){
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		// Have a radio button group with some items
		RadioButtonGroup<String> group = new RadioButtonGroup<>();
		group.setItems("Don't add initial inventory", "Add initail inventory");
		// Disable one item
//		group.setItemEnabledProvider(item-> !"Two".equals(item));
		addComponent(group);
		
		addComponent(formLayout);		
		List<Location> locations = this.partInitDataWrapperDto.getLocations();
		final ComboBox<Location> locationComb = new ComboBox<>("Location");
		binder.forField(locationComb).withValidator(new RequiredValidator()).bind(Tag::getLocation, Tag::setLocation);
		locationComb.setDataProvider(new CallbackDataProvider<Location, String>(query->locations.stream(), qyery->locations.size()));
		formLayout.addComponent(locationComb);
		
		final TextField quantityText = new TextField("Quantity");		
		ValueProvider<Tag, String> getQty = source -> source.getQty()+"";
		Setter<Tag, String> setQty = (bean, qty) -> {
			Integer q = new Integer(qty);
			bean.setQty(q);				
		};
		binder.bind(quantityText,getQty,setQty);
		formLayout.addComponent(quantityText);
		
	    uomComb = new ComboBox<Uom>("UOM");
		
		uomComb.setDataProvider(new CallbackDataProvider<Uom,String>(query->partInitDataWrapperDto.getUoms().stream(),query->partInitDataWrapperDto.getUoms().size()));
		formLayout.addComponent(uomComb);
		
		//Part cost: avg cost
		final TextField unitCostText = new TextField("Unit Cost");
		ValueProvider<Tag, String> getUnitCost = source->source.getPart().getPartCost().getAvgCost()+"";
		Setter<Tag, String> setUnitCost = (source,cost)->{float avgCost= new Float(cost); source.getPart().getPartCost().setAvgCost(avgCost);};
		binder.bind(unitCostText,getUnitCost, setUnitCost);
		formLayout.addComponent(unitCostText);
}

}
