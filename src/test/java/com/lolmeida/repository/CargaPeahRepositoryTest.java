package com.lolmeida.repository;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.PeahRepository;
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
public class CargaPeahRepositoryTest {

    @Mock
    private CargaPeahRepository cargaPeahRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(cargaPeahRepository.listAll(Sort.descending(anyString()))).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargaPeahRepository.findAll("id");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(cargaPeahRepository).listAll(Sort.descending("id"));
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(cargaPeahRepository.list(anyString(), anyString())).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargaPeahRepository.search("name", "example");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(cargaPeahRepository).list("LOWER(name) like ?1", "%example%");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(cargaPeahRepository.list(anyString(), anyString())).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargaPeahRepository.findBy("123");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(cargaPeahRepository).list("Client like ?1", "123");
    }

    @Test
    @Transactional
    public void testSave() {
        // Arrange
        Cargo cargo = new Cargo();
        cargo.setId(UUID.randomUUID().toString());

        // Act
        String savedId = cargaPeahRepository.save(cargo);

        // Assert
        assertEquals(cargo.getId(), savedId);
        verify(cargaPeahRepository).persistAndFlush(cargo);
    }
}