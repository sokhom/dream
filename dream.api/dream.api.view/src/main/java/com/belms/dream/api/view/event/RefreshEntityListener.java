package com.belms.dream.api.view.event;

public interface RefreshEntityListener<T> {
	T refresh(T entity);
}
