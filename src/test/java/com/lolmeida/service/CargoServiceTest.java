package com.lolmeida.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.repository.CargaPeahRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CargoServiceTest {

    @Mock
    private CargaPeahRepository repository;

    @Mock
    private CargoService cargoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cargoService = new CargoService(repository);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(repository.findAll(any())).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargoService.findAll("id");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(repository).findAll("id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(repository.search(anyString(), anyString())).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargoService.search("name", "example");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(repository).search("name", "example");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Cargo> expectedCargos = Arrays.asList(new Cargo(), new Cargo());
        when(repository.findBy(anyString())).thenReturn(expectedCargos);

        // Act
        List<Cargo> actualCargos = cargoService.findBy("123");

        // Assert
        assertEquals(expectedCargos, actualCargos);
        verify(repository).findBy("123");
    }

    @Test
    public void testSave() {
        // Arrange
        Cargo cargo = new Cargo();

        // Act
        String savedId = cargoService.save(cargo);

        // Assert
        assertEquals(savedId, cargo.getId());
        verify(repository).save(cargo);
    }
}