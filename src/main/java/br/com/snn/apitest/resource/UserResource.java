package br.com.snn.apitest.resource;

import br.com.snn.apitest.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @RequestMapping(value ="/{id}" )
    public ResponseEntity<User> findById(@PathVariable Integer id){

return ResponseEntity.ok().body(new User(1,"ser","trr@yy.lo","88877",12.09));
    }
}
