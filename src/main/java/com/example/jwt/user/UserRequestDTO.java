package com.example.jwt.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDTO {
    private String email;
    private String password;

    public User toEntity(){
        return User.builder().email(email).password(password).build();
    }
}
