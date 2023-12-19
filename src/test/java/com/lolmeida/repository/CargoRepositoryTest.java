package com.lolmeida.repository;


import com.lolmeida.entity.database.Cargo;
import io.quarkus.panache.common.Sort;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CargoRepositoryTest {

    @Mock
    private CargaPeahRepository cargaPeahRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Cargo cargo = new Cargo();
        when(cargaPeahRepository.findAll("id")).thenReturn(Arrays.asList(cargo));

        List<Cargo> result = cargaPeahRepository.findAll("id");
        assertEquals(1, result.size());
        verify(cargaPeahRepository, times(1)).findAll("id");
    }

    @Test
    public void testSearch() {
        Cargo cargo = new Cargo();
        when(cargaPeahRepository.search("name", "test")).thenReturn(Arrays.asList(cargo));

        List<Cargo> result = cargaPeahRepository.search("name", "test");
        assertEquals(1, result.size());
        verify(cargaPeahRepository, times(1)).search("name", "test");
    }

    @Test
    public void testFindBy() {
        Cargo cargo = new Cargo();
        when(cargaPeahRepository.findBy("1")).thenReturn(Arrays.asList(cargo));

        List<Cargo> result = cargaPeahRepository.findBy("1");
        assertEquals(1, result.size());
        verify(cargaPeahRepository, times(1)).findBy("1");
    }

    @Test
    public void testSave() {
        Cargo cargo = new Cargo();
        cargo.setId(UUID.randomUUID().toString());
        when(cargaPeahRepository.save(cargo)).thenReturn(cargo.getId());

        String result = cargaPeahRepository.save(cargo);
        assertEquals(cargo.getId(), result);
        verify(cargaPeahRepository, times(1)).save(cargo);
    }
}
