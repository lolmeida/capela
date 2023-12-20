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

import com.lolmeida.entity.database.Receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ApplicationScoped
public class ReceiptRepositoryTest {

    @Mock
    private ReceiptRepository receiptRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.listAll(Sort.descending(anyString()))).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptRepository.findAll("id");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).listAll(Sort.descending("id"));
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.list(anyString(), anyString())).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptRepository.search("name", "example");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).list("LOWER(name) like ?1", "%example%");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.list(anyString(), anyString())).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptRepository.findBy("123");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).list("id like ?1", "123");
    }

    @Test
    @Transactional
    public void testSave() {
        // Arrange
        Receipt receipt = new Receipt();
        receipt.setId(UUID.randomUUID().toString());

        // Act
        String savedId = receiptRepository.save(receipt);

        // Assert
        assertEquals(receipt.getId(), savedId);
        verify(receiptRepository).persistAndFlush(receipt);
    }
}