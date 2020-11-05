package com.thoughtworks.capacity.gtb.mvc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer Id;
    @NotNull(message= "username must not be null")
    @Pattern(message = "username is illegal", regexp = "^[\\w-]{3,10}$")
    private String username;
    @NotNull(message= "password must not be null")
    @Size(min = 5, max = 12, message = "password is illegal")
    private String password;
    @Pattern(message = "email is illegal", regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
