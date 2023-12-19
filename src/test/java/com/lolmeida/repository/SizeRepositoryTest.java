package com.lolmeida.repository;

import com.lolmeida.entity.database.Size;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ApplicationScoped
public class SizeRepositoryTest {

    @Mock
    private SizeRepository sizeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(sizeRepository.listAll(Sort.descending(anyString()))).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeRepository.findAll("id");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(sizeRepository).listAll(Sort.descending("id"));
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(sizeRepository.list(anyString(), anyString())).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeRepository.search("name", "example");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(sizeRepository).list("LOWER(name) like ?1", "%example%");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(sizeRepository.list(anyString(), anyString())).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeRepository.findBy("123");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(sizeRepository).list("id like ?1", "123");
    }

    @Test
    @Transactional
    public void testSave() {
        // Arrange
        Size size = new Size();
        size.setId(UUID.randomUUID().toString());

        // Act
        String savedId = sizeRepository.save(size);

        // Assert
        assertEquals(size.getId(), savedId);
        verify(sizeRepository).persistAndFlush(size);
    }
}