package br.com.francelino.apitestunitario.config;

import br.com.francelino.apitestunitario.domain.User;
import br.com.francelino.apitestunitario.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Fran", "fran2@mail.com", "123456");
        User u2 = new User(null, "saul", "saul2@mail.com", "123456");

        userRepository.saveAll(List.of(u1, u2));
    }
}
