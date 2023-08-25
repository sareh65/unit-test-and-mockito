package br.com.snn.apitest.services.impl;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;
import br.com.snn.apitest.repository.UserRepository;
import br.com.snn.apitest.services.UserService;
import br.com.snn.apitest.services.exception.DataIntegrityViolationException;
import br.com.snn.apitest.services.exception.ObjectNotFoundExeption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption("not found!"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj,User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.delete(findById(id));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegrityViolationException("This email is registred!");
        }

    }
}
