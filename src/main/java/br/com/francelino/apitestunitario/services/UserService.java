package br.com.francelino.apitestunitario.services;

import br.com.francelino.apitestunitario.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
