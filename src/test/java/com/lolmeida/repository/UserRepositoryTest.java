package com.lolmeida.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.quarkus.panache.common.Sort;

import com.lolmeida.entity.database.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ApplicationScoped
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(userRepository.listAll(Sort.descending(anyString()))).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userRepository.findAll("id");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).listAll(Sort.descending("id"));
    }

    @Test
    public void testSearch() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(userRepository.list(anyString(), anyString())).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userRepository.search("name", "example");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).list("LOWER(name) like ?1", "%example%");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(userRepository.list(anyString(), anyString())).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userRepository.findBy("123");

        // Assert
        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).list("id like ?1", "123");
    }

    @Test
    @Transactional
    public void testSave() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID().toString());

        // Act
        String savedId = userRepository.save(user);

        // Assert
        assertEquals(user.getId(), savedId);
        verify(userRepository).persistAndFlush(user);
    }
}