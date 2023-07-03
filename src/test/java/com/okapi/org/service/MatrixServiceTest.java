package com.okapi.org.service;

import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

}
