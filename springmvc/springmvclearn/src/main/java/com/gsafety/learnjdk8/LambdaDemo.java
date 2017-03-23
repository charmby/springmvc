package com.gsafety.learnjdk8;

import java.util.Arrays;
import java.util.function.Consumer;
/**
 * lambda表达式语法
 * @author xiaodh
		 *在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。例如：
		
		Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
		请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
		
		Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
		在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。例如：
		

		Arrays.asList( "a", "b", "d" ).forEach( e -> {
		    System.out.print( e );
		    System.out.print( e );
		} );
		Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。例如，下面两个代码片段是等价的：
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator ) );
		和：
		final String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator ) );
		Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是等价的：
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		和：
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
		
 */
public class LambdaDemo {
	public static void main(String[] args) {
     Arrays.asList("a","l","k","n").forEach(e -> System.out.println(e));
     
     Arrays.asList("a","l","k","n").forEach((String e) -> System.out.println(e));
	
     Arrays.asList( "a", "b", "d" ).forEach( e -> {
    	    System.out.print( e );
    	    System.out.print( e );
    	} );   
     
	 }
	/**
	 * 语言设计者投入了大量精力来思考如何使现有的函数友好地支持lambda。
	 * 最终采取的方法是：增加函数式接口的概念。函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换为lambda表达式.
	 * Java 8增加了一种特殊的注解@FunctionalInterface（Java 8中所有类库的已有接口都添加了@FunctionalInterface注解）
	 * 例如：default void forEach(Consumer<? super T> action)中的Consumer就有@FunctionalInterface注解
	 */
	public void isLambada(){
		
	}
	
}
