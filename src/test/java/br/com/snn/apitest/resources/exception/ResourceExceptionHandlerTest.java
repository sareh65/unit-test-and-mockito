package br.com.snn.apitest.resources.exception;

import br.com.snn.apitest.services.exception.ObjectNotFoundExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ResourceExceptionHandlerTest {
    public static final String NOT_FOUND = "not found!";
    public static final String OBJECT_NOT_FOUND = NOT_FOUND;
    @InjectMocks
private ResourceExceptionHandler resourceExceptionHandler;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void WhenObjectNotFoundReturnResponseEntity() {
        ResponseEntity<StandardError> response = resourceExceptionHandler
                .objectNotFound(new ObjectNotFoundExeption(OBJECT_NOT_FOUND), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class,response.getClass());
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(StandardError.class,response.getBody().getClass());
        assertEquals(404,response.getBody().getStatus());
        assertEquals(OBJECT_NOT_FOUND,response.getBody().getError());
    }

    @Test
    void dataIntegrityViolationException() {
    }
}