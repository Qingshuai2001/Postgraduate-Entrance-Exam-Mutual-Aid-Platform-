package com.qing.common;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 * @Target :  Target翻译中文为目标，即该注解可以声明在哪些目标元素之前，也可理解为注释类型的程序元素的种类。
 * ElementType.METHOD：该注解只能声明在一个类的方法前。
 * @Retention ：Retention 翻译成中文为保留，可以理解为如何保留，即告诉编译程序如何处理，也可理解为注解类的生命周期。
 * RetentionPolicy.RUNTIME  : 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
