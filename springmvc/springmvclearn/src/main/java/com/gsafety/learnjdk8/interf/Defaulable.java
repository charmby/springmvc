package com.gsafety.learnjdk8.interf;
/**
 * 默认方法
 * TODO 
 * @author xiaodh
 * 2017年3月23日 上午10:31:19
 */
public interface Defaulable {
	 // Interfaces now allow default methods, the implementer may or 
    // may not implement (override) them.
    default String notRequired() { 
        return "Default implementation"; 
    }      
}
