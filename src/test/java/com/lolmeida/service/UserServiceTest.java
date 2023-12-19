package com.lolmeida.service;

import com.lolmeida.entity.database.User;
import com.lolmeida.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService();
        userService.repository = repository;
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(repository.findAll(any())).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.findAll("id");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(repository).findAll("id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(repository.search(anyString(), anyString())).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.search("name", "example");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(repository).search("name", "example");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(repository.findBy(anyString())).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.findBy("123");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(repository).findBy("123");
    }

    @Test
    public void testSave() {
        // Arrange
        User user = new User();

        // Act
        String savedId = userService.save(user);

        // Assert
        assertEquals(savedId, user.getId());
        verify(repository).save(user);
    }
}