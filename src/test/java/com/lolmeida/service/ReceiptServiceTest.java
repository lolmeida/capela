package com.lolmeida.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.entity.database.Receipt;
import com.lolmeida.repository.ReceiptRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReceiptServiceTest {

    @Mock
    private ReceiptRepository receiptRepository;

    private ReceiptService receiptService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        receiptService = new ReceiptService(receiptRepository);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.findAll(any())).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptService.findAll("id");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).findAll("id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.search(anyString(), anyString())).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptService.search("field", "value");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).search("field", "value");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Receipt> expectedReceipts = Arrays.asList(new Receipt(), new Receipt());
        when(receiptRepository.findBy(anyString())).thenReturn(expectedReceipts);

        // Act
        List<Receipt> actualReceipts = receiptService.findBy("id");

        // Assert
        assertEquals(expectedReceipts, actualReceipts);
        verify(receiptRepository).findBy("id");
    }

    @Test
    public void testSave() {
        // Arrange
        Receipt receipt = new Receipt();

        // Act
        String savedId = receiptService.save(receipt);

        // Assert
        assertEquals(receipt.getId(), savedId);
        verify(receiptRepository).save(receipt);
    }
}