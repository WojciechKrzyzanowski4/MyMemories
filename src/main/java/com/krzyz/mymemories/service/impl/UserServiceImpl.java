package com.krzyz.mymemories.service.impl;

import com.krzyz.mymemories.dto.UserDto;
import com.krzyz.mymemories.exception.UserNotFoundException;
import com.krzyz.mymemories.model.User;
import com.krzyz.mymemories.repository.UserRepository;
import com.krzyz.mymemories.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        System.out.println("i am saving this user" + user.getEmail());
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }
    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
