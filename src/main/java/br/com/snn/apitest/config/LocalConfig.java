package br.com.snn.apitest.config;

import br.com.snn.apitest.domain.User;
import br.com.snn.apitest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
    private UserRepository repository;
    @Bean
    public void startDB(){
        User u1 = new User(null,"sareh","jhg@gg.mk",98.87,"12p03");
        User u2 = new User(null,"sopo","olg@gg.mk",12.27,"29ll00");
        User u3 = new User(null,"mana","opog@gg.mk",22.33,"9900pp");
        repository.saveAll(List.of(u1,u2,u3));
    }
}
