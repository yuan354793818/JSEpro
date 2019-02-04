package com.test.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})  //注解作用域
@Retention(RetentionPolicy.RUNTIME)  //注解作用时间
@Constraint(validatedBy = MyConstriantValidator.class) //执行校验逻辑的类
public @interface MyConstraint {

    //校验不过时候的信息
    String message() default "{大于100了！！}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
