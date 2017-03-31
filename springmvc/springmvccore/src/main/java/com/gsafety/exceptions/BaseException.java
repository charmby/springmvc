package com.gsafety.exceptions;

public class BaseException extends Exception {

	private static final long serialVersionUID = -6417999056338898261L;
	/**
	 * 异常标识码，有基础异常码+具体异常码组成
	 * 异常码生成规则：1-2标识平台或项目，3-4标识某个组件，5-7标识某个异常类，8-10：标识具体异常原因--无用了
	 */
	private String code;
	/**
	 * 异常信息
	 */
	private String message;
	/**
	 * 异常对象
	 */
	private Throwable exception;
	/**
	 * 异常动态参数
	 */
	private Object [] params;

	/**
	 * 开发者异常信息
	 */
	private String developerMsg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 异常信息
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 异常信息
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 异常对象
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * 异常对象
	 * @param exception
	 */
	public void setException(Throwable exception) {
		this.exception = exception;
	}
	/**
	 * 异常动态参数
	 */
	public Object[] getParams() {
		return params;
	}
	/**
	 * 异常动态参数
	 * @param params
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	/**
	 * 开发者异常信息
	 */
	public String getDeveloperMsg() {
		return developerMsg;
	}
	/**
	 * 开发者异常信息
	 * @param developerMsg
	 */
	public void setDeveloperMsg(String developerMsg) {
		this.developerMsg = developerMsg;
	}
	/**
	 * 
	 * @param code
	 * @param message
	 * @param exception
	 * @param params
	 * @param developerMsg
	 */
	public BaseException(String code, String message, Throwable exception, Object[] params, String developerMsg) {
		this.code = code;
		this.message = message;
		this.exception = exception;
		this.params = params;
		this.developerMsg = developerMsg;
	}

	public BaseException() {
		super();
	}

	public BaseException(String code, String message, Object[] params) {
		super();
		this.code = code;
		this.message = message;
		this.params = params;
	}
	public BaseException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BaseException(String code, String message, Throwable exception, String developerMsg) {
		super();
		this.code = code;
		this.message = message;
		this.exception = exception;
		this.developerMsg = developerMsg;
	}

}
