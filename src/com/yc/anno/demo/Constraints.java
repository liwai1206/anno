package com.yc.anno.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 外哥
 * @Description:
 * @email : liwai2012220663@163.com
 * @date 2021/1/16 9:43
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    public boolean primaryKey() default false ;
    public boolean allowNull() default true ;
    public boolean unique() default false ;
    public boolean autoIncrement() default false ;
}
