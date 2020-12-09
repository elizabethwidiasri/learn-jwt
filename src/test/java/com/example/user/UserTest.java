package com.example.user;


import com.example.jwt.user.User;
import com.example.jwt.user.UserResponseDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void toResposeDTO_shouldReturnUserResponseDTO_whenInvokedByUser() {
        UserResponseDTO expectedResult = UserResponseDTO.builder().id(1L).email("pius@mail.com").build();
        User pius = User.builder().id(1L).email("pius@mail.com").password("12345").build();

        UserResponseDTO actualResult =  pius.toResponseDTO();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
