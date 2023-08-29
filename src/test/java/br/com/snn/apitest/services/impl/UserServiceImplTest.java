package br.com.snn.apitest.services.impl;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;
import br.com.snn.apitest.repository.UserRepository;
import br.com.snn.apitest.services.exception.DataIntegrityViolationException;
import br.com.snn.apitest.services.exception.ObjectNotFoundExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID = 1;
    public static final String NAME = "mina";
    public static final String EMAIL = "mina@ui.com";
    public static final double WEIGHT = 12.00;
    public static final String PASSWORD = "1200";
    public static final String NOT_FOUND = "not found!";
    public static final int INDEX = 0;
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;
    private User user;
    private UserDTO userDTO;
    private Optional<User> userOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, WEIGHT, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, WEIGHT, PASSWORD);
        userOptional = Optional.of(new User(ID, NAME, EMAIL, WEIGHT, PASSWORD));
    }

    @Test
    void findByIdTest() {
        when(repository.findById(anyInt())).thenReturn(userOptional);
        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class,response.getClass());
        assertEquals(EMAIL,response.getEmail());
        assertEquals(ID,response.getId());
        assertEquals(NAME,response.getName());
        assertEquals(WEIGHT,response.getWeight());

    }
    @Test
    void objectNotFoundById(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundExeption(NOT_FOUND));

        try{service.findById(ID);

        }catch(Exception ex){
            assertEquals(ObjectNotFoundExeption.class,ex.getClass());
            assertEquals(NOT_FOUND,ex.getMessage());

        }
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(response.get(INDEX).getClass(), User.class);
        assertEquals(1,response.size());
        assertEquals(ID,response.get(INDEX).getId());
        assertEquals(EMAIL,response.get(INDEX).getEmail());
        assertEquals(NAME,response.get(INDEX).getName());
        assertEquals(WEIGHT,response.get(INDEX).getWeight());

    }

    @Test
    void whenCreateComSucces() {
        when(repository.save(any())).thenReturn(user);

        User response = service.create(userDTO);
        assertNotNull(response);
        assertEquals(User.class,response.getClass());
        assertEquals(EMAIL,response.getEmail());
        assertEquals(ID,response.getId());
        assertEquals(NAME,response.getName());
        assertEquals(WEIGHT,response.getWeight());

    }
    @Test
    void whenCreateException() {
        when(repository.findByEmail(anyString())).thenReturn(userOptional);

        try{
            userOptional.get().setId(2);
            service.create(userDTO);
        }catch (Exception ex){
           assertEquals(DataIntegrityViolationException.class,ex.getClass());
           assertEquals("This email is registred!",ex.getMessage());
        }

    }

    @Test
    void whenUpdateComSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.update(userDTO);
        assertNotNull(response);
        assertEquals(User.class,response.getClass());
        assertEquals(EMAIL,response.getEmail());
        assertEquals(ID,response.getId());
        assertEquals(NAME,response.getName());
        assertEquals(WEIGHT,response.getWeight());

    }

    @Test
    void delete() {
    }
}