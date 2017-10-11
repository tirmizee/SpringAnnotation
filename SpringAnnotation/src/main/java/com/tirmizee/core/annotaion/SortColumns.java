
package com.tirmizee.core.annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tirmizee
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD  })  
@Inherited
@Documented
public @interface  SortColumns { 
	
	String[] value() default {}; 
	
}
