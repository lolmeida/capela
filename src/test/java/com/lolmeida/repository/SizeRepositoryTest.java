// FILEPATH: /Users/lourencoalmeida/Desktop/APP/JAVA/Quarkus/capela/src/test/java/com/lolmeida/repository/SizeRepositoryTest.java
package com.lolmeida.Repository;

import com.lolmeida.entity.database.Size;
import com.lolmeida.repository.SizeRepository;

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
public class SizeRepositoryTest {

    @Mock
    private SizeRepository sizeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Size size = new Size();
        when(sizeRepository.findAll("id")).thenReturn(Arrays.asList(size));

        List<Size> result = sizeRepository.findAll("id");
        assertEquals(1, result.size());
        verify(sizeRepository, times(1)).findAll("id");
    }

    @Test
    public void testSearch() {
        Size size = new Size();
        when(sizeRepository.search("name", "test")).thenReturn(Arrays.asList(size));

        List<Size> result = sizeRepository.search("name", "test");
        assertEquals(1, result.size());
        verify(sizeRepository, times(1)).search("name", "test");
    }

    @Test
    public void testFindBy() {
        Size size = new Size();
        when(sizeRepository.findBy("1")).thenReturn(Arrays.asList(size));

        List<Size> result = sizeRepository.findBy("1");
        assertEquals(1, result.size());
        verify(sizeRepository, times(1)).findBy("1");
    }

    @Test
    @Transactional
    public void testSave() {
        Size size = new Size();
        size.setId(UUID.randomUUID().toString());
        when(sizeRepository.save(size)).thenReturn(size.getId());

        String result = sizeRepository.save(size);
        assertEquals(size.getId(), result);
        verify(sizeRepository, times(1)).save(size);
    }
}