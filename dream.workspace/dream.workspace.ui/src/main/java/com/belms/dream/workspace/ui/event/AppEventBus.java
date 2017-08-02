/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui.event;

import java.io.Serializable;

import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.ui.AppUI;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

public class AppEventBus implements SubscriberExceptionHandler, Serializable{

	private static final long serialVersionUID = 1L;
	private final EventBus eventBus = new EventBus(this);
	private static EventBusProvider eventBusProvider;

	public static void post(final Object event){
		AppUI.getAppEventBus().eventBus.post(event);
	}
	
	public static void register(final Object object){
		AppUI.getAppEventBus().eventBus.register(object);
	}
	
	public static void  unregesiter(final Object object) {
		AppUI.getAppEventBus().eventBus.unregister(object);
		
	}
	
	
	@Override
	public void handleException(final Throwable exception, final SubscriberExceptionContext context) {
		exception.printStackTrace();
	}

	public static EventBusProvider getEventBusProvider(){
		if(eventBusProvider==null){
			eventBusProvider = new EventBusProvider() {
				
				@Override
				public void unregister(Object object) {
					AppEventBus.unregesiter(object);
				}
				
				@Override
				public void register(Object object) {
					AppEventBus.register(object);
					
				}
				
				@Override
				public void post(Object event) {
					AppEventBus.post(event);
				}
			};
		}
		
		return eventBusProvider;
	}

}
