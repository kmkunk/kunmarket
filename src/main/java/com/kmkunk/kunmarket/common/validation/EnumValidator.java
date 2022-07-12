//package com.kmkunk.kunmarket.common.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
///**
// * Enum type validation
// * 참고 https://jsy1110.github.io/2022/enum-class-validation/
// */
//public class EnumValidator implements ConstraintValidator<ValidEnum, Enum> {
//    private ValidEnum annotation;
//
//    @Override
//    public void initialize(ValidEnum constraintAnnotation) {
//        this.annotation = constraintAnnotation;
//    }
//
//    @Override
//    public boolean isValid(Enum value, ConstraintValidatorContext context) {
//        boolean result = false;
//        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
//        if (enumValues != null) {
//            for (Object enumValue : enumValues) {
//                if (value == enumValue) {
//                    result = true;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//}
