
package org.es.util.excelutil;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* ���������Ҫ����Ϊxsl�ļ�������
* @author tigerJay
* @version 
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OutName {
     public String value() default "";
}
 