package br.com.snn.apitest.services;

import br.com.snn.apitest.domain.User;

public interface UserService {
    public User findById(Integer id);
}
