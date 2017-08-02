/***
 * @author ngounphanny
 * 
 */

package com.belms.dream.workspace.common.newview;

import java.util.List;

import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.View;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractNewView<T> extends Window implements View {

	private static final long serialVersionUID = 1L;
	private final EventBusProvider eventBusProvider;
	private final Panel stepViewPanel = new Panel();
	private int currentStepIndex = 0;
	private List<StepView<T>> stepViews;
	private AddnewEntityListener<T> addnewEntityListener; 

	public AbstractNewView(EventBusProvider eventBusProvider) {
		this.eventBusProvider = eventBusProvider;
	}

	@Override
	public void initView() {
		
		setModal(true);
		this.stepViews = getStepViews();
		
		HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
		eventBusProvider.register(this);
		this.addCloseListener(event -> eventBusProvider.unregister(this));

		splitPanel.setSizeFull();
		splitPanel.setSplitPosition(200, Unit.PIXELS);
		splitPanel.setMinSplitPosition(100, Unit.PIXELS);
		splitPanel.setMaxSplitPosition(600, Unit.PIXELS);
		buildStepPanel(splitPanel);
		VerticalLayout layout = new VerticalLayout();
		splitPanel.setSecondComponent(layout);
		layout.setSizeFull();
		layout.setSpacing(false);
		layout.setMargin(false);
		buildStackView(layout);
		buildButtons(layout);
		setContent(splitPanel);

		stepViewChanged();
	}

	
	protected void setAddnewEntityListener(AddnewEntityListener<T> addnewEntityListener) {
		this.addnewEntityListener = addnewEntityListener;
	}
	
	
	protected abstract T getNewItem();
	

	private void stepViewChanged() {
		if (stepViews == null || stepViews.size() == 0) {
			return;
		}
		eventBusProvider.post(new StepViewSelectedEvent<T>(getCurrentStepView()));
	}

	private void buildButtons(VerticalLayout layout) {

		final HorizontalLayout footerLayout = new HorizontalLayout();
		footerLayout.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
		layout.addComponent(footerLayout);
		footerLayout.setWidth(100, Unit.PERCENTAGE);
		footerLayout.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
	
		footerLayout.setMargin(false);
		footerLayout.setSpacing(false);

		final Button backButton = new Button("Back");
		final Button nextButton = new Button("Next");

		if(currentStepIndex+1 >= stepViews.size() ){
			nextButton.setEnabled(false);
		}
		
		backButton.addClickListener(event -> {
			if (currentStepIndex - 1 >= 0) {
				currentStepIndex--;
				stepViewChanged();
			}

			if (currentStepIndex <= 0) {
				backButton.setEnabled(false);
			}

			if (!nextButton.isEnabled() && stepViews.size() > 1) {
				nextButton.setEnabled(true);
			}
		});

		nextButton.addClickListener(event -> {
		
			if(!this.getCurrentStepView().isValid()){
				Notification.show("Data is not valid to go next", Type.ERROR_MESSAGE);
				return;
			}
			
			if (currentStepIndex + 1 < stepViews.size()) {
				currentStepIndex++;
				stepViewChanged();
			}

			if (currentStepIndex + 1 >= stepViews.size()) {
				nextButton.setEnabled(false);
			}

			if (!backButton.isEnabled()) {
				backButton.setEnabled(true);
			}

		});

		final Button finishButton = new Button("Finish");
		
		finishButton.addClickListener(event-> {
			for (StepView<T> stepView : stepViews) {
				if(stepView.validationRequired() && !stepView.isValid()) {
					eventBusProvider.post(new StepViewSelectedEvent<T>(stepView));
					
					Notification.show("Invalid data. Saving cannot be fullfilled", Type.ERROR_MESSAGE);
					return;
				}
				
			}
			
			try {
				addnewEntityListener.addNew(getNewItem());
				Notification.show("Save sucessfully", Type.HUMANIZED_MESSAGE);
				close();
			}catch (Exception e) {
				Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
			}
			
			
		});
		
		final Button cancelButton = new Button("Cancel");

		cancelButton.addClickListener(event -> {
			close();
		});

		CssLayout group = new CssLayout(backButton, nextButton, finishButton, cancelButton);
		group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		footerLayout.addComponent(group);
	}
	
	private StepView<T> getCurrentStepView(){
		
		if(this.stepViews==null || this.stepViews.size()==0){
			throw new RuntimeException("No step view setup");
		}
		
		return this.stepViews.get(currentStepIndex);
	}
	
	private void buildStepPanel(HorizontalSplitPanel mainPanel) {
		final CssLayout stepItemsLayout = new CssLayout();
		mainPanel.setFirstComponent(stepItemsLayout);
		stepItemsLayout.setPrimaryStyleName("valo-menu");
		stepItemsLayout.addStyleName("valo-menuitems");

		stepItemsLayout.addComponent(new Label("Step"));

		if (stepViews == null) {
			return;
		}

		int i = 0;
		for (StepView<T> stepView : stepViews) {
			i++;
			stepItemsLayout.addComponent(new StepItem(this, i, stepView));
		}
	}

	private void buildStackView(VerticalLayout layout) {
		layout.addComponent(stepViewPanel);
		layout.setExpandRatio(stepViewPanel, 1);
		stepViewPanel.setSizeFull();
	}

	@Subscribe
	public void setStepView(StepViewSelectedEvent<T> event) {
		this.stepViewPanel.setCaption(event.getStepView().getName());
		this.stepViewPanel.setContent(event.getStepView().getView());
	}

	protected abstract List<StepView<T>> getStepViews();

	private class StepItem extends Label {

		private static final long serialVersionUID = 1L;
		private static final String STYLE_SELECTED = "selected";
		private final StepView<T> stepView;

		public StepItem(Window window, int order, StepView<T> stepView) {

			this.stepView = stepView;
			setPrimaryStyleName("valo-menu-item");
			String caption = String.format("%d-%s ", order, stepView.getName());
			eventBusProvider.register(this);
			window.addCloseListener(event -> eventBusProvider.unregister(this));
			setValue(caption);
		}

		@Subscribe
		public void stepViewChanged(StepViewSelectedEvent<T> event) {
			System.out.println(event.getStepView().getName());
			removeStyleName(STYLE_SELECTED);
			if (stepView.getName().equals(event.getStepView().getName())) {
				addStyleName(STYLE_SELECTED);
			}
		}

	}

}
