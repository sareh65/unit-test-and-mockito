package br.com.snn.apitest.resource;

import br.com.snn.apitest.domain.dto.UserDTO;
import br.com.snn.apitest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
   private ModelMapper mapper;
    @Autowired
    private UserService userService;
    @RequestMapping(value ="/{id}" )
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){

return ResponseEntity.ok().body(mapper.map(userService.findById(id),UserDTO.class));
    }
}
