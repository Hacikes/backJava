package org.ruslan.investingapp.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.model.Role;
import org.ruslan.investingapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role getUserRole() {
        final String name = "USER";
        return repository.findByName(name).orElseThrow(() -> {
            String msg = String.format("Role with name %s not found", name);
            return new EntityNotFoundException(msg);
        });
    }
}
