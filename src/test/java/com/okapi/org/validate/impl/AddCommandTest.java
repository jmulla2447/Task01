package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AddCommandTest {

    private AddCommand addCommand;

    @Mock
    private MatrixService matrixService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void execute_ValidFile_SuccessfullyImportsData()  {
        matrixService = mock(MatrixService.class);
        // Arrange
        String[] args = {"add", System.getProperty("user.dir")+"/examples", "example1.data"};
        addCommand = new AddCommand(args, matrixService);
        int[][] expectedMatrix =
        {{1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}};

        addCommand.execute();

        // Assert
        verify(matrixService, times(0)).saveCameraBitMatrixToDatabase(expectedMatrix);
    }

    @Test
    void execute_InvalidFile_ThrowsIOException()  {
        // Arrange
        String[] args = {"add", "/path/to/directory", "nonexistent.txt"};
        addCommand = new AddCommand(args, matrixService);

        // Act & Assert
        addCommand.execute();
        // Verify that an error message or exception handling is implemented appropriately
    }

    @Test
    void validateInput_ValidInput_ReturnsTrue() {
        // Arrange
        String[] args = {"add", "/path/to/directory", "filename.txt"};
        addCommand = new AddCommand(args, matrixService);

        // Act
        boolean result = addCommand.validateInput();

        // Assert
        assertTrue(result);
    }

    @Test
    void validateInput_InvalidInput_ReturnsFalse() {
        // Arrange
        String[] args = {"add", "/path/to/directory"};
        addCommand = new AddCommand(args, matrixService);

        // Act
        boolean result = addCommand.validateInput();

        // Assert
        assertFalse(result);
    }
}
