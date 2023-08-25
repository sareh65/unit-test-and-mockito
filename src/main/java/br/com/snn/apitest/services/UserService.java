package br.com.snn.apitest.services;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    public User findById(Integer id);
    public List<User> findAll();
    public User create(UserDTO obj);
}
