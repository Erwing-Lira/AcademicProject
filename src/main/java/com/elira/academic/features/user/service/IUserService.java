package com.elira.academic.features.user.service;

import com.elira.academic.features.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> editById(Long id, User user);
    Optional<User> deleteById(Long id);
}
