package br.com.snn.apitest.services.impl;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;
import br.com.snn.apitest.repository.UserRepository;
import br.com.snn.apitest.services.exception.ObjectNotFoundExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID = 1;
    public static final String NAME = "mina";
    public static final String EMAIL = "mina@ui.com";
    public static final double WEIGHT = 12.00;
    public static final String PASSWORD = "1200";
    public static final String NOT_FOUND = "not found!";
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

    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}