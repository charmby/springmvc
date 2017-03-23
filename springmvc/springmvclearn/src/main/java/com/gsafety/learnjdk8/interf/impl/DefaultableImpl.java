package com.gsafety.learnjdk8.interf.impl;

import com.gsafety.learnjdk8.interf.Defaulable;

public class DefaultableImpl  implements Defaulable{

	/**
	 * 但是默认方法则没有这个要求。相反，每个接口都如果有必要的话，可以覆盖这个默认实现.
	 * 但是default关键字，不需要.且必须使用public
	 **/
	@Override
	public String notRequired() {
		return "Overridden implementation";
	}
}
