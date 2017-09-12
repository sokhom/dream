package com.belms.dream.workspace.part.comps;

import java.util.List;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

public class AddPartToTrackingView extends AbstractSimpleDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PartTracking> partTrackings;
	private SaveEntityListener<PartToTracking> saveEntityListener;
	private Binder<PartToTracking> binder;
	
	public AddPartToTrackingView(SaveEntityListener<PartToTracking> saveEntityListener,OPER_TYPE operType, List<PartTracking> partTrackings) {
		binder = new Binder<PartToTracking>();
		this.partTrackings=partTrackings;
		this.saveEntityListener = saveEntityListener;
		setWidth(700, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		setOpterationType(operType);
		binder.setBean(saveEntityListener.getBean(getOperationType()));
		
	}

	
	@Override
	protected String getDialogCaption() {
		
		return "Part Tracking";
	}

	@Override
	protected void buildContentLayout(VerticalLayout parent) {
		final ComboBox<PartTracking> pTrackingComb = new ComboBox<PartTracking>("Part Tracking");
		pTrackingComb.setDataProvider(new CallbackDataProvider<PartTracking, String>(query->partTrackings.stream(), qyery->partTrackings.size()));
		parent.addComponent(pTrackingComb);		
		setOkButtonClickListener(event -> {
//			if(!binder.validate().isOk()) {
//				Notification.show("Input data is not valid", Type.ERROR_MESSAGE);
//				return;
//			}
		
			PartToTracking pToTracking =binder.getBean();
			pToTracking.setPartTracking(pTrackingComb.getSelectedItem().get());
			saveEntityListener.save(pToTracking, getOperationType());
			close();
//			binder.setBean(saveEntityListener.getBean(getOperationType()));
//			addressTypeComboBox.focus();
//			if(OPER_TYPE.EDIT == getOperationType()) {
//				close();
//			}
		});
		
	}

}
