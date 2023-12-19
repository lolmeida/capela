// FILEPATH: /Users/lourencoalmeida/Desktop/APP/JAVA/Quarkus/capela/src/test/java/com/lolmeida/repository/ClientRepositoryTest.java
package com.lolmeida.Repository;

import com.lolmeida.entity.Client;
import com.lolmeida.repository.ClientRepository;

import io.quarkus.panache.common.Sort;
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
public class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Client client = new Client();
        when(clientRepository.findAll("id")).thenReturn(Arrays.asList(client));

        List<Client> result = clientRepository.findAll("id");
        assertEquals(1, result.size());
        verify(clientRepository, times(1)).findAll("id");
    }

    @Test
    public void testSearch() {
        Client client = new Client();
        when(clientRepository.search("name", "test")).thenReturn(Arrays.asList(client));

        List<Client> result = clientRepository.search("name", "test");
        assertEquals(1, result.size());
        verify(clientRepository, times(1)).search("name", "test");
    }

    @Test
    public void testFindBy() {
        Client client = new Client();
        when(clientRepository.findBy("1")).thenReturn(Arrays.asList(client));

        List<Client> result = clientRepository.findBy("1");
        assertEquals(1, result.size());
        verify(clientRepository, times(1)).findBy("1");
    }

    @Test
    @Transactional
    public void testSave() {
        Client client = new Client();
        client.setId(UUID.randomUUID().toString());
        when(clientRepository.save(client)).thenReturn(client.getId());

        String result = clientRepository.save(client);
        assertEquals(client.getId(), result);
        verify(clientRepository, times(1)).save(client);
    }
}