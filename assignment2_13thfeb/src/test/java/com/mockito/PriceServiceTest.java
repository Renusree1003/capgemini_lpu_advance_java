package com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class PriceServiceTest {

    @Test
    public void testCalculateFinalPrice_Mobile() {

        DiscountRepository repoMock = mock(DiscountRepository.class);

        when(repoMock.getDiscountPercentage("MOB")).thenReturn(10.0);

        PriceService service = new PriceService(repoMock);

        double result = service.calculateFinalPrice(1000, "MOB");

        assertEquals(900, result);

        verify(repoMock).getDiscountPercentage("MOB");
    }

    @Test
    public void testCalculateFinalPrice_Laptop() {

        DiscountRepository repoMock = mock(DiscountRepository.class);

        when(repoMock.getDiscountPercentage("LAP")).thenReturn(20.0);

        PriceService service = new PriceService(repoMock);

        double result = service.calculateFinalPrice(2000, "LAP");

        assertEquals(1600, result);

        verify(repoMock).getDiscountPercentage("LAP");
    }

    @Test
    public void testRepositoryThrowsException() {

        DiscountRepository repoMock = mock(DiscountRepository.class);

        when(repoMock.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("Product not found"));

        PriceService service = new PriceService(repoMock);

        assertThrows(RuntimeException.class, () -> {
            service.calculateFinalPrice(1000, "ERR");
        });

        verify(repoMock).getDiscountPercentage("ERR");
    }
}
