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
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    // 默认表名就是类名
    public String name() default  "" ;
}
