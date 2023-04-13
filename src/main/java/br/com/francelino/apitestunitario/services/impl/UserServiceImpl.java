package br.com.francelino.apitestunitario.services.impl;

import br.com.francelino.apitestunitario.domain.User;
import br.com.francelino.apitestunitario.domain.dto.UserDTO;
import br.com.francelino.apitestunitario.repositories.UserRepository;
import br.com.francelino.apitestunitario.services.UserService;
import br.com.francelino.apitestunitario.services.exceptions.DataIntegratyViolationException;
import br.com.francelino.apitestunitario.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("Email já cadastrado no sistema");
        }
    }

}
