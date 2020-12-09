package com.example.jwt.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void addUser_shouldReturnHttpStatusOf201AndUserResponseDTO_whenInvoked() throws Exception {
        UserRequestDTO userRequestDTO = UserRequestDTO.builder().email("pius@mail.com").password("12345").build();
        String requestBody = this.objectMapper.writeValueAsString(userRequestDTO);
        UserResponseDTO expectedResponseDTO = UserResponseDTO.builder().id(1L).email("pius@mail.com").build();
        String expectedStringResponseDTO = this.objectMapper.writeValueAsString(expectedResponseDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8").content(requestBody);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
        String stringContent = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(expectedStringResponseDTO, stringContent);
    }
}
