package com.elira.academic.features.user.service;

import com.elira.academic.features.user.model.User;
import com.elira.academic.features.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private final UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        userRepository.findAll().forEach(user -> {
            System.out.println(user.toString());
        });
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> editById(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User newUser = optionalUser.get();
            if (user.getName() != null) {
                newUser.setName(user.getName());
            }
            if (user.getEmail() != null) {
                newUser.setEmail(user.getEmail());
            }
            return Optional.of(userRepository.save(newUser));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(userRepository::delete);
        return optionalUser;
    }
}
