package com.example.jwt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = User.builder().email(userRequestDTO.getEmail()).password(userRequestDTO.getPassword()).build();
        User savedUser = this.userRepository.save(user);
        return new ResponseEntity<>(savedUser.toResponseDTO(), HttpStatus.CREATED);
    }
}
