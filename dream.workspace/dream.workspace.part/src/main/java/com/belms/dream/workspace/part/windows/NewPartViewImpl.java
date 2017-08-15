package com.belms.dream.workspace.part.windows;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.step.PartInfoStepView;
import com.blems.dream.api.model.part.Part;

public class NewPartViewImpl extends AbstractNewView<Part> implements INewPartView  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String CAPTION = "<h3><b>New Part wizard</b></h3>";
	private PartInitDataWrapperDto partInitDataWrapper;
	public NewPartViewImpl(EventBusProvider eventBusProvider,PartInitDataWrapperDto partInitDataWrapper) {
		super(eventBusProvider);
		eventBusProvider.register(this);
		this.partInitDataWrapper = partInitDataWrapper;
		setCaption(CAPTION);
		setCaptionAsHtml(true);
		center();
		setWidth(900, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
	}

	

	@Override
	protected Part getNewItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<StepView<Part>> getStepViews() {
		List<StepView<Part>> steps = new ArrayList<>();
		steps.add(new PartInfoStepView());
		return steps;
	}

}
