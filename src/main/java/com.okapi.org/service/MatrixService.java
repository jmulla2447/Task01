package com.okapi.org.service;

import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import com.okapi.org.service.stretagy.ItemCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatrixService {
    private final MatrixRepository matrixRepository;

    @Autowired
    public MatrixService(MatrixRepository matrixRepository) {
        this.matrixRepository = matrixRepository;
    }

    public void saveCameraBitMatrixToDatabase(int[][] matrix) {
        MatrixEntity matrixEntity = new MatrixEntity();
        matrixEntity.setData(matrix);
        matrixRepository.save(matrixEntity);
    }

    public int countItemsFromDatabase(final boolean isDiagonalCount) {
        long count = matrixRepository.findAll().stream()
                .mapToInt(matrix -> countItems(matrix.getData(), isDiagonalCount))
                .sum();

        return Math.toIntExact(count);
    }

    private static int countItems(int[][] matrix, boolean isDiagonalCount) {
        ItemCounter counter = new ItemCounter(isDiagonalCount);
        return counter.countItems(matrix);
    }

}
