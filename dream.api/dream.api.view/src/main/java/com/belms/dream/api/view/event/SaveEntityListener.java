package com.belms.dream.api.view.event;

public interface SaveEntityListener<T> {
	public enum OPER_TYPE {ADD, EDIT, VIEW , CONFIRM}
	void save(T bean, OPER_TYPE type);
	T getBean(OPER_TYPE type);
}
