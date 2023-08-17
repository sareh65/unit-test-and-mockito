package br.com.snn.apitest.resource;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    private UserService userService;
    @RequestMapping(value ="/{id}" )
    public ResponseEntity<User> findById(@PathVariable Integer id){

return ResponseEntity.ok().body(userService.findById(id));
    }
}
