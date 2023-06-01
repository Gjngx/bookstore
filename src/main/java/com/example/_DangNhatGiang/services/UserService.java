package com.example._DangNhatGiang.services;

import com.example._DangNhatGiang.entity.User;
import com.example._DangNhatGiang.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
