package br.com.snn.apitest.services.impl;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.repository.UserRepository;
import br.com.snn.apitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserRepository repository;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
