package com.neostarteon.backend.controllers;

import com.neostarteon.backend.models.User;
import com.neostarteon.backend.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

/**
 * https://medium.com/@hantsy/protect-rest-apis-with-spring-security-and-jwt-5fbc90305cc5
 * https://vladmihalcea.com/change-one-to-one-primary-key-column-jpa-hibernate/
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signUp")
    public ResponseEntity createUser(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ok(userService.createUser(user));
    }

    @GetMapping("")
    @ResponseBody
    @ApiOperation(value = "", authorizations = {@Authorization(value = "Bearer")})
    public ResponseEntity getAllUsers() {
        return ok(userService.getAllUsers());
    }

    @GetMapping("/{Id}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "Bearer")})
    public User getUser(@PathVariable Long Id) {
        return userService.getUserById(Id);
    }


}
