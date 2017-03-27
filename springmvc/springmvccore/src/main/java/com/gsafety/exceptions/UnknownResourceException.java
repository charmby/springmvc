package com.gsafety.exceptions;

public class UnknownResourceException extends RuntimeException {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3324827816087886977L;
 public UnknownResourceException(String msg){
   super(msg);
 }
}
