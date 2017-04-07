package com.gsafety.exceptions.common;

import java.util.ArrayList;
import java.util.List;

import com.gsafety.exceptions.BaseException;
/**
 * 
 * 平台逻辑异常通用异常类 
 * @author xiaodh
 * 2017年3月31日 下午4:15:17
 */
public class GsafetyException extends BaseException {

	private static final long serialVersionUID = -4330469259776750250L;
	/**
	 * 异常列表
	 */
	private List<Throwable> causes = new ArrayList<Throwable>();
	
	public GsafetyException(String code, String message, Throwable exception, Object[] params, String developerMsg) {
		super(code, message, exception, params, developerMsg);
	}
	
	public List<Throwable> getCauses() {
		return causes;
	}
	public void setCauses(List<Throwable> causes) {
		this.causes = causes;
	}
	public GsafetyException(List<Throwable> causes) {
		this.causes.addAll(causes);
	}

	public GsafetyException() {
		super();
	}

	public GsafetyException(String code, String message, Throwable exception, String developerMsg,
			List<Throwable> causes) {
		super(code, message, exception, developerMsg);
		this.causes = causes;
	}

	public GsafetyException(String code, String message, Object[] params) {
		super(code, message, params);
	}

	public GsafetyException(String code, String message, Throwable exception, String developerMsg) {
		super(code, message, exception, developerMsg);
	}

	public GsafetyException(String code, String message) {
		super(code, message);
	}

}
