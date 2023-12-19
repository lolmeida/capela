// FILEPATH: /Users/lourencoalmeida/Desktop/APP/JAVA/Quarkus/capela/src/test/java/com/lolmeida/repository/ReceiptRepositoryTest.java
package com.lolmeida.Repository;

import com.lolmeida.entity.database.Receipt;
import com.lolmeida.repository.ReceiptRepository;

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
public class ReceiptRepositoryTest {

    @Mock
    private ReceiptRepository receiptRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Receipt receipt = new Receipt();
        when(receiptRepository.findAll("id")).thenReturn(Arrays.asList(receipt));

        List<Receipt> result = receiptRepository.findAll("id");
        assertEquals(1, result.size());
        verify(receiptRepository, times(1)).findAll("id");
    }

    @Test
    public void testSearch() {
        Receipt receipt = new Receipt();
        when(receiptRepository.search("name", "test")).thenReturn(Arrays.asList(receipt));

        List<Receipt> result = receiptRepository.search("name", "test");
        assertEquals(1, result.size());
        verify(receiptRepository, times(1)).search("name", "test");
    }

    @Test
    public void testFindBy() {
        Receipt receipt = new Receipt();
        when(receiptRepository.findBy("1")).thenReturn(Arrays.asList(receipt));

        List<Receipt> result = receiptRepository.findBy("1");
        assertEquals(1, result.size());
        verify(receiptRepository, times(1)).findBy("1");
    }

    @Test
    @Transactional
    public void testSave() {
        Receipt receipt = new Receipt();
        receipt.setId(UUID.randomUUID().toString());
        when(receiptRepository.save(receipt)).thenReturn(receipt.getId());

        String result = receiptRepository.save(receipt);
        assertEquals(receipt.getId(), result);
        verify(receiptRepository, times(1)).save(receipt);
    }
}