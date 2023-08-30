package br.com.snn.apitest.resources;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.domain.dto.UserDTO;
import br.com.snn.apitest.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserResourceTest {
    @InjectMocks
    private UserResource resource;
    @Mock
    private UserService service;
    @Mock
    private ModelMapper mapper;
    private User user;
    private UserDTO userDTO;
    public static final Integer ID = 1;
    public static final String NAME = "mina";
    public static final String EMAIL = "mina@ui.com";
    public static final double WEIGHT = 12.00;
    public static final String PASSWORD = "1200";
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }
    private void startUser() {
        user = new User(ID, NAME, EMAIL, WEIGHT, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, WEIGHT, PASSWORD);
    }

    @Test
    void findById() {
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