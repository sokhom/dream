package com.belms.dream.api.view.fragment;

public interface EventBusBridge {
	void post(Object event);
	void registor(Object object);
	void unregistor(Object object);
}
