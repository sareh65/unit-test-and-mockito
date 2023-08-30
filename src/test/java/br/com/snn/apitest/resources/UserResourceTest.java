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
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
    void whenFindByIdWithSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(),any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class,response.getClass());
        assertEquals(UserDTO.class,response.getBody().getClass());
        assertEquals(ID,response.getBody().getId());
        assertEquals(EMAIL,response.getBody().getEmail());
        assertEquals(NAME,response.getBody().getName());
        assertEquals(WEIGHT,response.getBody().getWeight());
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