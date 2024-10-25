package com.company.viewaudit.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreViewAudit {

    boolean value() default true;
}
