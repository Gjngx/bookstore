package com.example._DangNhatGiang.Validator;


import com.example._DangNhatGiang.Validator.annotation.ValidCategoryId;
import com.example._DangNhatGiang.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
        @Override
        public boolean isValid(Category category, ConstraintValidatorContext context) {
            return category != null && category.getId() != null;
        }
}
