package com.producio.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.producio.backend.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
    public User findByName(String username);
    public boolean existsByUsername(String username);
}
