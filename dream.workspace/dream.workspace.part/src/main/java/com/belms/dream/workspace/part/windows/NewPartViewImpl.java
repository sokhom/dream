package com.belms.dream.workspace.part.windows;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.step.PartInfoStepView;
import com.belms.dream.workspace.part.step.PartToTrackingStepView;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;

public class NewPartViewImpl extends AbstractNewView<Part> implements INewPartView  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String CAPTION = "<h3><b>New Part wizard</b></h3>";
	private PartInitDataWrapperDto partInitDataWrapper;
	private Part part;
	public NewPartViewImpl(EventBusProvider eventBusProvider,PartInitDataWrapperDto partInitDataWrapper) {
		super(eventBusProvider);
		eventBusProvider.register(this);
		this.partInitDataWrapper = partInitDataWrapper;
		setCaption(CAPTION);
		setCaptionAsHtml(true);
		center();
		setWidth(900, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		
		part = new Part();
		
		initView();
	}	

	@Override
	protected Part getNewItem() {		
		return part;
	}

	@Override
	protected List<StepView<Part>> getStepViews() {
		List<StepView<Part>> steps = new ArrayList<>();
		steps.add(new PartInfoStepView(partInitDataWrapper));
		steps.add(new PartToTrackingStepView(partInitDataWrapper));
		
		for (StepView<Part> stepView : steps) {
			stepView.loadData(part);
		}
		return steps;
	}

}
