package com.krzyz.mymemories.repository;

import com.krzyz.mymemories.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    void deleteUserById(Long id);
    User findUserByEmail(String email);
}
