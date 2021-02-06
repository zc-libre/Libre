
package com.libre.common.annotation;

import java.lang.annotation.*;

/**
 * @author zhaocheng
 */
@Inherited
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {

}
