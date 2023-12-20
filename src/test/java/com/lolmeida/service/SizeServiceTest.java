package com.lolmeida.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.entity.database.Size;
import com.lolmeida.repository.SizeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SizeServiceTest {

    @Mock
    private SizeRepository repository;

    private SizeService sizeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        sizeService = new SizeService(repository);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(repository.findAll(any())).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeService.findAll("id");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(repository).findAll("id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(repository.search(anyString(), anyString())).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeService.search("name", "example");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(repository).search("name", "example");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Size> expectedSizes = Arrays.asList(new Size(), new Size());
        when(repository.findBy(anyString())).thenReturn(expectedSizes);

        // Act
        List<Size> actualSizes = sizeService.findBy("123");

        // Assert
        assertEquals(expectedSizes, actualSizes);
        verify(repository).findBy("123");
    }

    @Test
    public void testSave() {
        // Arrange
        Size size = new Size();

        // Act
        String savedId = sizeService.save(size);

        // Assert
        assertEquals(savedId, size.getId());
        verify(repository).save(size);
    }
}