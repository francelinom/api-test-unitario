package br.com.francelino.apitestunitario.services;

import br.com.francelino.apitestunitario.domain.User;

public interface UserService {

    User findById(Integer id);
}
