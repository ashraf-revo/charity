package org.revo.charity.Service.Impl;

import io.micrometer.core.lang.Nullable;
import org.revo.charity.Domain.User;
import org.revo.charity.Repository.UserRepository;
import org.revo.charity.Service.UserService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(@Nullable String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findListByEmail(@Nullable String email) {
        return userRepository.findListByEmail(email);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
