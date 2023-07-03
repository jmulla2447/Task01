package com.okapi.org.service;

import com.okapi.org.model.entity.MatrixEntity;
import com.okapi.org.repository.MatrixRepository;
import com.okapi.org.service.stretagy.ItemCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatrixService {
    private final MatrixRepository matrixRepository;
    private final static Logger LOG = LoggerFactory.getLogger(MatrixService.class);

    @Autowired
    public MatrixService(MatrixRepository matrixRepository) {
        this.matrixRepository = matrixRepository;
    }

    public void saveCameraBitMatrixToDatabase(int[][] matrix) {
        MatrixEntity matrixEntity = new MatrixEntity();
        matrixEntity.setData(matrix);
        matrixRepository.save(matrixEntity);
    }

    public void countItemsFromDatabase(final boolean isDiagonalCount) {
        if (isDiagonalCount) {
            int count = matrixRepository.findAll().stream()
                    .mapToInt(matrix -> countItems(matrix.getData(), isDiagonalCount))
                    .sum();
            LOG.info("Total count for Diagonal Matrix Data is {}.", count);
        } else {
            matrixRepository.findAll()
                    .forEach(matrix -> fetchItems(matrix.getData(), isDiagonalCount));
        }
    }

    private static int countItems(int[][] matrix, boolean isDiagonalCount) {
        ItemCounter counter = new ItemCounter(isDiagonalCount);
        return counter.countItems(matrix);
    }

    private static void fetchItems(int[][] matrix, boolean isDiagonalCount) {
        ItemCounter counter = new ItemCounter(isDiagonalCount);
        counter.fetchItems(matrix).forEach(ele -> LOG.info(ele + " "));
    }

}
