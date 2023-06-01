package com.example._DangNhatGiang.Validator;

import com.example._DangNhatGiang.Validator.annotation.ValidUsername;
import com.example._DangNhatGiang.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return  userRepository.findByUsername(username) == null;
    }
}
