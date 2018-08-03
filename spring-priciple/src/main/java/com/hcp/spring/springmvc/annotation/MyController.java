package com.hcp.spring.springmvc.annotation;

import java.lang.annotation.*;

/**
 * Created by hcp on 2018/8/3.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {
    String value() default "";
}
