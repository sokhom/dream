package com.belms.dream.workspace.part.comps;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tag.Tag;
import com.blems.dream.api.model.tracking.PartTracking;
import com.blems.dream.api.model.tracking.PartTrackingType;
import com.blems.dream.api.model.tracking.TrackingText;
import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.server.Setter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class InventoryTrackingView extends VerticalLayout  implements EntryView<Part>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CHECK_BOX_TRACKING = "Check Box";
	private static final String COUNT_TRACKING = "Count";
	private static final String DATE_TRACKING = "Date";
	private static final String EXPIRATION_DATE_TRACKING = "Expiration Date";
	private static final String MONEY_TRACKING = "Money";
	private static final String QUANTITY_TRACKING = "Quantity";
	private static final String SERIAL_NUMBER_TRACKING = "Serial Number";
	private static final String TEXT_TRACKING = "Text";
	
	
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private Binder<Tag> binder;
	private Part part;
	public InventoryTrackingView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;		
	}
	@Override
	public boolean isValid() {		
		return false;
	}

	@Override
	public Component getView() {		
		return this;
	}

	@Override
	public void loadData(Part data) {		
//		List<PartToTracking> partTTrackints = data.getPartToTrackings();
		this.part = data;
		Tag tag = part.getTags().get(0);
		this.binder.setBean(tag);
		initUI();
	}
	
	private void initUI(){
		int compCount = getComponentCount();
		if(compCount>0){
			removeAllComponents();
		}
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
	
		List<PartToTracking> partToTrackings = part.getPartToTrackings();		
		for (PartToTracking partToTracking : partToTrackings) {
			PartTracking pTracking = partToTracking.getPartTracking();
			PartTrackingType pTrackingType = pTracking.getType();
			String trackingType = pTrackingType.getName();
			String trackingName =pTracking.getName();
			boolean isSelected = partToTracking.isSelectedFlag();
			
			if(isSelected){
				if(TEXT_TRACKING.equals(trackingType)){
					final TextField lotText = new TextField(trackingName);					
					ValueProvider<Tag,String> getter = source ->source.getTrackingTextMapping(pTracking).getName();			
					Setter<Tag, String> setter =(bean,fieldvalue)->{bean.getTrackingTextMapping(pTracking).setName(fieldvalue);};
					binder.forField(lotText).bind(getter, setter);
					
					formLayout.addComponent(lotText);	
					
				}else if(EXPIRATION_DATE_TRACKING.equals(trackingType)){
					final DateField expireDateText = new DateField(trackingName);
					ValueProvider<Tag,LocalDate> getter = source ->{
						
						source.getTrackingDate().getInfo().toString();
				              return  LocalDate.now();
					};	
					Setter<Tag, LocalDate> setter =(bean,fieldvalue)->{
						Date date = new Date(fieldvalue.toString()) ; 
						bean.getTrackingDate().setInfo(date);};
					binder.forField(expireDateText).bind(getter, setter);
					
					formLayout.addComponent(expireDateText);				
				}else if(SERIAL_NUMBER_TRACKING.equals(trackingType)){
					//			
				}
			}
		}
		
	}
	
}
