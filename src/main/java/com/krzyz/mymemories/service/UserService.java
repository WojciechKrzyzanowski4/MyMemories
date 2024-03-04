package com.krzyz.mymemories.service;

import com.krzyz.mymemories.dto.UserDto;
import com.krzyz.mymemories.model.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserById(Long id);

    List<User> findAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);

    User findUserByEmail(String email);

}
