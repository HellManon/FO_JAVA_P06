package com.example.paymybuddy;


import com.example.paymybuddy.dto.UserDto;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {

    private final User user = new User();
    private final UserDto userDto = new UserDto();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        user.setId(1L);
        user.setName("John");
        user.setEmail("john@gmail.com");
        user.setPassword("456");

        userDto.setName("John");
        userDto.setEmail("john@gmail.com");
        userDto.setPassword("456");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        when(userRepository.save(any(User.class))).thenReturn(user);
    }

    @AfterEach
    public void cleanUser() {
        userRepository.deleteAll();
    }

    @Test
    public void testFindUserById() {
        Optional<User> userFound = userService.findById(user.getId());
        assertEquals("John", userFound.get().getName());
    }

    @Test
    public void testFindAllUser() {
        assertEquals(1, userService.findAll().size());
    }

    @Test
    public void testSaveUser() {
        long userId = userService.saveUser(userDto);
        assertEquals(user.getId(), userId);
    }
}