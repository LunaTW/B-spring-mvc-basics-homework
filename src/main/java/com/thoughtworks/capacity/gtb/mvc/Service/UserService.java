package com.thoughtworks.capacity.gtb.mvc.Service;

//import com.thoughtworks.capacity.gtb.mvc.Service.Exception.UserAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.Model.User;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import com.thoughtworks.capacity.gtb.mvc.Service.Exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public UserService() {
    }

    public void createUser(User user) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findUserByName(user.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User already exist");
        }
        userRepository.insert(user);
    }
}
