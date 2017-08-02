package com.belms.dream.api.view.event;

public interface EventBusProvider {
	void post(Object event);
	void register(Object object);
	void unregister(Object object);
}
