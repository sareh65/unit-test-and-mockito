package br.com.snn.apitest.services;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
