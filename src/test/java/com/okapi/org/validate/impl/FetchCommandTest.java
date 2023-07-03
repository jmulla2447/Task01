package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FetchCommandTest {

    private FetchCommand fetchCommand;

    @Mock
    private MatrixService matrixService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ValidInput_CallsCountItemsFromDatabase() {
        // Arrange
        String[] args = {"fetch", "arg1"};
        fetchCommand =  new FetchCommand(args, matrixService);

        // Act
        fetchCommand.execute();

        // Assert
        verify(matrixService, times(1)).countItemsFromDatabase(true);
    }

    @Test
    void validateInput_ValidInput_ReturnsTrue() {
        // Arrange
        String[] args = {"fetch", "arg1"};
        fetchCommand =  new FetchCommand(args, matrixService);

        // Act
        boolean result = fetchCommand.validateInput();

        // Assert
        assertTrue(result);
    }

    @Test
    void validateInput_InvalidInput_ReturnsFalse() {
        // Arrange
        String[] args = {"fetch"};
        fetchCommand =  new FetchCommand(args, matrixService);

        // Act
        boolean result = fetchCommand.validateInput();

        // Assert
        assertFalse(result);
    }
}
