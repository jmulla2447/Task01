package com.okapi.org.service;
import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MatrixServiceTest {

    @Mock
    private MatrixRepository matrixRepository;

    private MatrixService matrixService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        matrixService = new MatrixService(matrixRepository);
    }

    @Test
    public void saveCameraBitMatrixToDatabase_ValidMatrix_SuccessfullySavesToDatabase() {
        int[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};

        matrixService.saveCameraBitMatrixToDatabase(matrix);

        // Verify that the matrixEntity object is saved to the repository
        verify(matrixRepository, times(1)).save(any(MatrixEntity.class));
    }

    @Test
    public void countItemsFromDatabase_DiagonalCount_ReturnsItemCount() {
        int[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        MatrixEntity matrixEntity = new MatrixEntity();
        matrixEntity.setData(matrix);

        when(matrixRepository.findAll()).thenReturn(List.of(matrixEntity));

        int count = matrixService.countItemsFromDatabase(true);

        assertEquals(1, count);
    }

    @Test
    public void countItemsFromDatabase_NonDiagonalCount_ReturnsItemCount() {
        int[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        MatrixEntity matrixEntity = new MatrixEntity();
        matrixEntity.setData(matrix);

        when(matrixRepository.findAll()).thenReturn(List.of(matrixEntity));

        int count = matrixService.countItemsFromDatabase(false);

        assertEquals(5, count);
    }
}
