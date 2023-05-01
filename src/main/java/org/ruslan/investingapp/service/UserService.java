package org.ruslan.investingapp.service;

import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.model.User;
import org.ruslan.investingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }


}
