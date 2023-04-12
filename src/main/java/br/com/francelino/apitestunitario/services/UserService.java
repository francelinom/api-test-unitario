package br.com.francelino.apitestunitario.services;

import br.com.francelino.apitestunitario.domain.User;
import br.com.francelino.apitestunitario.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO obj);
}
