package com.test.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstriantValidator implements ConstraintValidator<MyConstraint,Integer> {//两个泛型分别为自定义注解和要校验的类型
    public boolean isValid(Integer o, ConstraintValidatorContext constraintValidatorContext) {

            if (o > 100) {
                return false;
            }else{
                return true;
            }

    }

}
