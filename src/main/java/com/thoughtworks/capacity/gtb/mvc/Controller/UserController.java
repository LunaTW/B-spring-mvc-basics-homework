package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Service.Exception.WrongInformationException;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import com.thoughtworks.capacity.gtb.mvc.Model.User;
import com. thoughtworks.capacity.gtb.mvc.Service.Exception.UserAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Post // register
    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) throws UserAlreadyExistsException  {
        userService.createUser(user);
    }

    // GeT // login
    @GetMapping(value = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User login(@RequestParam(name = "username")
                      @NotBlank(message = "username cannot be empty")
                      @Pattern(regexp = "[0-9a-zA-Z_]{3,10}$", message = "illegal username")
                      String username,
                      @RequestParam(name = "password")
                      @Size(max = 12, min = 5, message = "illegal password")
                      @NotBlank(message = "password cannot be empty")
                      String password) throws WrongInformationException {
        return userService.login(username, password);
    }
}
