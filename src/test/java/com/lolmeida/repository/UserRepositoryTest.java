// FILEPATH: /Users/lourencoalmeida/Desktop/APP/JAVA/Quarkus/capela/src/test/java/com/lolmeida/repository/UserRepositoryTest.java
package com.lolmeida.Repository;

import com.lolmeida.entity.database.User;
import com.lolmeida.repository.UserRepository;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@QuarkusTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        User user = new User();
        when(userRepository.findAll("id")).thenReturn(Arrays.asList(user));

        List<User> result = userRepository.findAll("id");
        assertEquals(1, result.size());
        verify(userRepository, times(1)).findAll("id");
    }

    @Test
    public void testSearch() {
        User user = new User();
        when(userRepository.search("name", "test")).thenReturn(Arrays.asList(user));

        List<User> result = userRepository.search("name", "test");
        assertEquals(1, result.size());
        verify(userRepository, times(1)).search("name", "test");
    }

    @Test
    public void testFindBy() {
        User user = new User();
        when(userRepository.findBy("1")).thenReturn(Arrays.asList(user));

        List<User> result = userRepository.findBy("1");
        assertEquals(1, result.size());
        verify(userRepository, times(1)).findBy("1");
    }

    @Test
    @Transactional
    public void testSave() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        when(userRepository.save(user)).thenReturn(user.getId());

        String result = userRepository.save(user);
        assertEquals(user.getId(), result);
        verify(userRepository, times(1)).save(user);
    }
}