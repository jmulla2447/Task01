package com.okapi.org.service;

import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@BootstrapWith(MatrixServiceIntegrationTest.Bootstrapper.class)
public class MatrixServiceIntegrationTest {

    @Autowired
    private MatrixService matrixService;

    @Autowired
    private MatrixRepository matrixRepository;

    @Autowired
    CommandLineRunner commandLineRunner;


    @Test
    public void testSaveCameraBitMatrixToDatabase() {
        // Arrange
        int[][] matrix = {{1, 1, 0}, {1, 0, 1}};

        // Act
       // matrixService.saveCameraBitMatrixToDatabase(matrix);

        // Assert
        int countItems = matrixService.countItemsFromDatabase(true);
        assertEquals(8, countItems);
    }

    @Test
    public void testCountItemsFromDatabase() {
        // Arrange
        int[][] matrix1 = {{1, 1, 0}, {1, 0, 1}};
        int[][] matrix2 = {{0, 1, 1}, {0, 1, 0}};
        MatrixEntity matrixEntity1 = new MatrixEntity();
        MatrixEntity matrixEntity2 = new MatrixEntity();
        matrixEntity1.setData(matrix1);
        matrixEntity2.setData(matrix2);

        matrixRepository.save(matrixEntity1);
        matrixRepository.save(matrixEntity2);

        // Act
        int itemCount = matrixService.countItemsFromDatabase(true);

        // Assert
        assertEquals(8, itemCount);
    }
}
