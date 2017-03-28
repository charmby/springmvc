package com.gsafety.learnjdk8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.slf4j.Logger;



public class RepeatingAnnotations {
private static Logger loger= org.slf4j.LoggerFactory.getLogger(RepeatingAnnotations.class);
	@Target( ElementType.TYPE )
	@Retention( RetentionPolicy.RUNTIME )
	public @interface Filters {
		Filter[] value();
	}
	@Target( ElementType.TYPE )
	@Retention( RetentionPolicy.RUNTIME )
	@Repeatable( Filters.class )
	public @interface Filter {
		String value();
	};
	
	@Filter( "filter1" )
	@Filter( "filter2" )
	public interface Filterable {
	}
	public static void main(String[] args) {
		for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
			loger.debug(filter.value());
		}}}