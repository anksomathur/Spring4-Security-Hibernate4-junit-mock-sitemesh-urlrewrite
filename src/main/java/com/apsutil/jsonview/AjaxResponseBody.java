package com.apsutil.jsonview;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody<T> {
	
	@JsonView(Views.Public.class)
	T obj;

	@JsonView(Views.Public.class)
	List<T> objList;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public List<T> getObjList() {
		return objList;
	}

	public void setObjList(List<T> objList) {
		this.objList = objList;
	}
}
