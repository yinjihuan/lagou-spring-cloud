package org.spring.cloud.multiple.demo.common.base;

/**
 * REST API 返回数据格式类
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-14
 * 
 */
public class ResponseData<T> {
	private int code = 200;
	private String message = "";
	private T data;

	public boolean isOk() {
		if(this.code == ResponseCode.SUCCESS_CODE.getCode() && this.data != null){
			return true;
		}
		return false;
	}
	
	public ResponseData<T> ok(T data) {
		this.data = data;
		return this;
	}

	public ResponseData<T> ok(T data, String message) {
		this.data = data;
		this.message = message;
		return this;
	}

	public ResponseData<T> fail() {
		this.code = ResponseCode.SERVER_ERROR_CODE.getCode();
		return this;
	}

	public ResponseData<T> fail(String message) {
		this.code = ResponseCode.SERVER_ERROR_CODE.getCode();
		this.message = message;
		return this;
	}

	public ResponseData<T> fail(String message, ResponseCode code) {
		this.message = message;
		this.code = code.getCode();
		return this;
	}

	public ResponseData<T> fail(String message, int code) {
		this.message = message;
		this.code = code;
		return this;
	}

	public ResponseData(T data) {
		super();
		this.data = data;
	}

	public ResponseData(String message) {
		super();
		this.message = message;
	}

	public ResponseData(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ResponseData() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
