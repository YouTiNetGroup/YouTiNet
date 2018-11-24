package com.youti.api.utils;

/**
 * 返回数据包装实体
 */
public class RespEntity {
 
	private Boolean isSuccess;//状态
	private Object data;//数据对象
	private String message;//消息
	
	public RespEntity(){}
	
	public RespEntity(Boolean issuccess, Object data, String message){
		this.isSuccess = issuccess;
		this.data = data;
		this.message = message;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
