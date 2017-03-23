package com.gsafety.learnjdk8.interf;

/**
 * 默认方法与静态方法并不影响函数式接口的契约
 * @author xiaodh
 * 2017年3月23日 上午10:17:51
 * 
 * 1、默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。相反，每个接口都必须提供一个所谓的默认实现，这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）  
 * 
 */
@FunctionalInterface
public interface FunctionalDefaultMethods {
    void method();
    default void defaultMethod() {            
    }   
    
    
}   