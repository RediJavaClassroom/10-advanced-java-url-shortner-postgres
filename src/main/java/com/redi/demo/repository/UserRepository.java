package com.redi.demo.repository;

import com.redi.demo.repository.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByPassword(final String password);
    User findByEmailOrderByName(final String email);
}
